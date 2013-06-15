package com.wannaride.mvc.tp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TripProviderHomeController {

    @RequestMapping(value = {"/tp", "/tp/index"}, method = RequestMethod.GET)
    public String showIndexPage(Map<String, Object> model){
        return "tp/index";
    }

}
