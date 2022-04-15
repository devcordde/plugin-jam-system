package com.github.devcordde.pluginjamsystem.web.api.v1;


import com.github.devcordde.pluginjamsystem.dto.User;
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


    private final OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    public UserDataController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }


    @GetMapping(path = "/current")
    public ResponseEntity<User> getLoggedInUser() {
        return ResponseEntity.ok(new User(
                "ysl#98999",
                "Otto",
                "https://randomuser.me/api/portraits/women/85.jpg"
        ));
    }

    @GetMapping()
    public String getLoginInfo(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());

        return "Login accomplished. Hello " + authentication.getPrincipal().getAttributes().get("username") + ""
                + "See implementation at github.com/Samurus/spring-boot-discord-oauth-example";
    }
}
