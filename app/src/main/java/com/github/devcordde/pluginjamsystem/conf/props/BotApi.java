package com.github.devcordde.pluginjamsystem.conf.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "discord-bot")
public record BotApi(String baseUrl, String token) {
}
