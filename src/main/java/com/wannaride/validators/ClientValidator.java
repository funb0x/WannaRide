package com.wannaride.validators;

import com.wannaride.dataAccess.UserDAO;
import com.wannaride.entity.Client;
import com.wannaride.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ClientValidator implements Validator{

    @Autowired
    private UserDAO userDAO;



    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Client client = (Client) target;
        User user = client.getUser();

        Pattern p;
        Matcher m;

        String login = user.getLogin();

        if (login.length() < 5 || login.length() > 24 ) {
            errors.rejectValue("user.login", "", "Login must be between 5 and 24 characters long.");
        }

        p = Pattern.compile("^[a-zA-Z0-9]+$");
        m = p.matcher(login);

        if (!m.matches())  {
            errors.rejectValue("user.login", "", "Login must be alphanumeric with no spaces");
        }

        if (!userDAO.chekLoginAvailability(login))  {
            errors.rejectValue("user.login", "", "This login is taken");
        }

        String password = user.getPassword();
        if (password.length() < 6 || password.length() > 12 ) {
            errors.rejectValue("user.password", "", "Password must be between 6 and 12 characters long.");
        }

        String email = user.getEmail();

        p = Pattern.compile("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
        m = p.matcher(email);

        if (!m.matches()) {
            errors.rejectValue("user.email", "", "Invalid email address.");
        }

        if (!userDAO.chekEmailAvailability(email))  {
            errors.rejectValue("user.email", "", "This email is taken");
        }

        String cell = user.getCell();
        p = Pattern.compile("^((8|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        m = p.matcher(cell);
        if (!m.matches()) {
            errors.rejectValue("user.cell", "", "Wrong cellphone number. Input like +38 0XX XXX XX XX");
        }

    }
}
