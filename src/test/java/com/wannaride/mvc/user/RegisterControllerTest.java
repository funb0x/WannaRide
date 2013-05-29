package com.wannaride.mvc.user;

import com.wannaride.entity.Client;
import com.wannaride.validators.ClientValidator;
import org.junit.Test;
import org.springframework.validation.BindingResult;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class RegisterControllerTest {

    RegisterController registerController = new RegisterController();

    @Test
    public void shouldReturnStringRegister(){

        HashMap<String,Object> model = new HashMap<>();

        String viewName = registerController.showRegisterPage(model);

        assertEquals("user/register", viewName);
    }

    @Test
    public void shouldReturnStringRegisterAfterFalseValidation(){


       Client client = new Client();

        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        ClientValidator clintValidator = Mockito.mock(ClientValidator.class);

        registerController.setClientValidator(clintValidator);

        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = registerController.handleRegisterForm(client, bindingResult);

        assertEquals("user/register", viewName);
    }

    @Test
    public void shouldReturnStringRegisterAfterSuccessfulValidation(){


        Client client = new Client();

        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        ClientValidator clintValidator = Mockito.mock(ClientValidator.class);

        registerController.setClientValidator(clintValidator);

        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = registerController.handleRegisterForm(client, bindingResult);

        assertEquals("redirect:/index", viewName);
    }

}
