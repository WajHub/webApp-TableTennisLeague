package com.leagueTT.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/login")
public class UserController {
    @RequestMapping("")
    public String login(){
        return "login";
    }
}
