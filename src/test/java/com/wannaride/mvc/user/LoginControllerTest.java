package com.wannaride.mvc.user;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest {

    LoginController loginController = new LoginController();

    @Test
    public void shouldReturnStringLogin(){

        HashMap<String,Object> model = new HashMap<>();

        String viewName = loginController.showLoginPage(model);

        assertEquals("user/login", viewName);
    }


}
