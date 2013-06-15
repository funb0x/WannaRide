package com.wannaride.mvc.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

public class HomeControllerTest {

    HomeController homeController;

    @Before
    public void setup(){
        homeController = new HomeController();
    }

    @Test
    public void shouldReturnStringIndex(){

        HashMap<String,Object> model = new HashMap<>();

        String viewName = homeController.showIndexPage(model);

        assertEquals("user/index", viewName);
    }


}
