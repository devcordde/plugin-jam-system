package com.github.devcordde.pluginjamsystem.web.pages;

import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.resolver.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

    @GetMapping("/")
    public String greeting(Model model, @UserInfo User user) {
        model.addAttribute("user", user);
        return "index";
    }
}
