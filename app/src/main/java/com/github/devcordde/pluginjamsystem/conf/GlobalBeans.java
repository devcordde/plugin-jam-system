package com.github.devcordde.pluginjamsystem.conf;

import com.github.devcordde.pluginjamsystem.resolver.DiscordUserResolver;
import com.github.devcordde.pluginjamsystem.resolver.GitlabUserResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@Configuration
@EnableTransactionManagement
public class GlobalBeans {


    @Bean
    @Primary
    @Qualifier("user-resolver")
    @ConditionalOnProperty(name = "auth-settings.auth-type", havingValue = "GITLAB")
    public HandlerMethodArgumentResolver gitlab() {
        return new GitlabUserResolver();
    }

    @Bean
    @Primary
    @Qualifier("user-resolver")
    @ConditionalOnProperty(name = "auth-settings.auth-type", havingValue = "DISCORD", matchIfMissing = true)
    public HandlerMethodArgumentResolver discord() {
        return new DiscordUserResolver();
    }
}
