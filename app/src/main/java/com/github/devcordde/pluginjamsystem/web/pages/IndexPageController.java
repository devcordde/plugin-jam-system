package com.github.devcordde.pluginjamsystem.web.pages;

import com.github.devcordde.pluginjamsystem.dto.AuthUrl;
import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.resolver.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IndexPageController {

    private final List<AuthUrl> provider;

    @Autowired
    public IndexPageController(OAuth2ClientProperties oAuth2ClientProperties) {
        this.provider = getAuthUrlsFromProperties(oAuth2ClientProperties);
    }

    private List<AuthUrl> getAuthUrlsFromProperties(OAuth2ClientProperties oAuth2ClientProperties) {
        List<AuthUrl> authUrls = new ArrayList<>();
        var providers = oAuth2ClientProperties.getProvider();
        oAuth2ClientProperties.getRegistration().values().forEach(registration -> {
            authUrls.add(new AuthUrl(
                            registration.getClientName(),
                            "/oauth2/authorization/" + registration.getProvider()
                    )
            );
        });
        return authUrls;
    }


    @GetMapping("/")
    public String greeting(Model model, @UserInfo User user) {
        model.addAttribute("user", user);
        model.addAttribute("authUrls", provider);
        return "index";
    }
}
