package com.github.devcordde.pluginjamsystem.conf;

import com.github.devcordde.pluginjamsystem.conf.props.Oauth2ProviderToResolverMapping;
import com.github.devcordde.pluginjamsystem.resolver.UserInfoResolver;
import com.github.devcordde.pluginjamsystem.resolver.user.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

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
            Oauth2ProviderToResolverMapping oauth2ProviderToResolverMapping
    ) {
        userResolvers.forEach(userResolver -> {
            var mappedKey = oauth2ProviderToResolverMapping.getMapping().getOrDefault(userResolver.key(), userResolver.key());
            userResolverMap.put(mappedKey, userResolver);
        });
    }

    @Bean
    @Primary
    @Qualifier("user-resolver")
    public HandlerMethodArgumentResolver discord() {
        return new UserInfoResolver(this.userResolverMap);
    }
}
