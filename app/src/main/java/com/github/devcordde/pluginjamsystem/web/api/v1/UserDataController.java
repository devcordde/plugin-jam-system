package com.github.devcordde.pluginjamsystem.web.api.v1;


import com.github.devcordde.pluginjamsystem.dto.User;
import com.github.devcordde.pluginjamsystem.resolver.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserDataController {

    @GetMapping(path = "/current")
    public ResponseEntity<User> getLoggedInUser(@UserInfo User user) {
        return ResponseEntity.ok(user);
    }
}
