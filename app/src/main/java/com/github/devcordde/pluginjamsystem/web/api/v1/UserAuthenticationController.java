package com.github.devcordde.pluginjamsystem.web.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userdata")
public class UserAuthenticationController {



    private final OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    public UserAuthenticationController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }



    @GetMapping
    public String getLoginInfo(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());

        return "Login accomplished. Hello " + authentication.getPrincipal().getAttributes().get("username") + ""
                + "See implementation at github.com/Samurus/spring-boot-discord-oauth-example";
    }

}
