package com.leagueTT.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class UserController {
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/admin/content")
    public String adminContent(){
        return "adminContent";
    }
    
}
