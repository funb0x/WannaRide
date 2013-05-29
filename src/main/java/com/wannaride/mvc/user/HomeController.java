package com.wannaride.mvc.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController{

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndexPage(Map<String, Object> model){
        return "user/index";
    }

}