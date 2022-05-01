package com.github.devcordde.pluginjamsystem.conf;

import com.github.devcordde.pluginjamsystem.conf.props.Oauth2ProviderToResolverMapping;
import com.github.devcordde.pluginjamsystem.exceptions.RegistrationNeedsResolverException;
import com.github.devcordde.pluginjamsystem.resolver.UserInfoResolver;
import com.github.devcordde.pluginjamsystem.resolver.user.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class GlobalBeans {
    private final Map<String, UserResolver> userResolverMap = new HashMap<>();

    @Autowired
    public GlobalBeans(
            List<? extends UserResolver> userResolvers,
            Oauth2ProviderToResolverMapping oauth2ProviderToResolverMapping,
            OAuth2ClientProperties oAuth2ClientProperties
    ) throws RegistrationNeedsResolverException {

        Map<String, UserResolver> mapped = new HashMap<>();
        userResolvers.forEach(userResolver -> mapped.put(userResolver.key(), userResolver));


        List<String> notConfiguredRegistrationKey = new ArrayList<>();
        oAuth2ClientProperties.getRegistration().forEach((registrationKey, registration) -> {
            var configuredResolverType = oauth2ProviderToResolverMapping.getMapping().get(registrationKey);

            if (configuredResolverType == null) {
                notConfiguredRegistrationKey.add(registrationKey);
            }
            userResolverMap.put(registrationKey, mapped.get(configuredResolverType));
        });
        if (notConfiguredRegistrationKey.size() > 0) {
            throw new RegistrationNeedsResolverException(notConfiguredRegistrationKey);
        }
    }

    @Bean
    @Primary
    @Qualifier("user-resolver")
    public HandlerMethodArgumentResolver userResolver() {
        return new UserInfoResolver(this.userResolverMap);
    }

    @Bean
    public Filter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }
}
