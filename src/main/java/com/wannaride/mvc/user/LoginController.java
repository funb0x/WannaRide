package com.wannaride.mvc.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping({"/login"})
    public String showLoginPage(Map<String, Object> model){
        return "user/login";
    }

}