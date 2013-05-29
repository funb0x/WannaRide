package com.wannaride.mvc.user;

import com.wannaride.dataAccess.GenericDAO;
import com.wannaride.entity.Client;
import com.wannaride.entity.User;
import com.wannaride.validators.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    @Qualifier("genericDAO")
    private GenericDAO dao;

    @Autowired
    private ClientValidator clientValidator;

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String showRegisterPage(Map<String, Object> model){
        Client client = new Client();
        User user = new User();
        model.put("client", client);
        model.put("user", user);

        return "user/register";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String handleRegisterForm(@Valid Client client, BindingResult bindingResult){

        clientValidator.validate(client, bindingResult);

        if(bindingResult.hasErrors()){
            return "user/register";
        }

        return "redirect:/index";
    }

    public void setClientValidator(ClientValidator clientValidator){
        this.clientValidator = clientValidator;
    }

}