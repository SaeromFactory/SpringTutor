package com.han.controllers;

import com.han.models.CommonResponse;
import com.han.models.User;
import com.han.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by high on 2017. 11. 18..
 */
@RequestMapping("users")
@RestController
public class UserController {
    @Autowired private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public CommonResponse login(@ModelAttribute User user) {
        return userService.login(user);
    }
}
