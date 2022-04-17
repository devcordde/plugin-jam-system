package com.github.devcordde.pluginjamsystem.conf.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "oauth.registration-to-user-resolver-type")
public class Oauth2ProviderToResolverMapping {
    private Map<String, String> mapping = new HashMap<>();

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
