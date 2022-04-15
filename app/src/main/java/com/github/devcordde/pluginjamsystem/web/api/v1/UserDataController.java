package com.github.devcordde.pluginjamsystem.web.api.v1;


import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.resolver.DiscordUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserDataController {

    private static final Logger log = LoggerFactory.getLogger(UserDataController.class);


    private final OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    public UserDataController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }


    @GetMapping(path = "/current")
    public ResponseEntity<User> getLoggedInUser(@DiscordUser User user) {


//        OAuth2AuthorizedClient client = authorizedClientService
//                .loadAuthorizedClient(
//                        authentication.getAuthorizedClientRegistrationId(),
//                        authentication.getName());
//
//
//        var attributes = authentication.getPrincipal().getAttributes();
//        attributes.forEach((s, o) -> {
//            log.info("name: {}, value: {}", s, o);
//        });

        return ResponseEntity.ok(user);
    }
}
