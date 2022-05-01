package com.github.devcordde.pluginjamsystem.web.pages;

import com.github.devcordde.pluginjamsystem.dto.AuthUrl;
import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.resolver.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IndexPageController {

    private final Collection<OAuth2ClientProperties.Registration> provider;

    @Autowired
    public IndexPageController(OAuth2ClientProperties oAuth2ClientProperties) {
        this.provider = oAuth2ClientProperties.getRegistration().values();
    }


    @GetMapping("/")
    public String greeting(Model model, @UserInfo User user, HttpServletRequest httpServletRequest) {
        var path = httpServletRequest.getContextPath();
        var authUrls = provider.stream().map(registration -> new AuthUrl(
                registration.getClientName(),
                path + "/oauth2/authorization/" + registration.getProvider()
        )).toList();


        model.addAttribute("user", user);
        model.addAttribute("authUrls", authUrls);
        return "index";
    }
}
