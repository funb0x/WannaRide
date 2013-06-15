package com.wannaride.mvc.tp;

import com.wannaride.dataAccess.GenericDAO;
import com.wannaride.dataAccess.UserDAO;
import com.wannaride.entity.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class TripProviderTransportController {

    @Autowired
    @Qualifier("genericDAO")
    private GenericDAO dao;

    @RequestMapping(value = {"/tp/transport"}, method = RequestMethod.GET)
    public String showTransportPage(Map<String, Object> model){

        List<Transport> transports = dao.getAll(Transport.class);

        model.put("transports", transports);
        model.put("transport", new Transport());

        return "tp/transport";
    }

    @RequestMapping(value = {"/tp/transport"}, method = RequestMethod.POST)
    public String handleFormShowTransport(@Valid Transport transport, BindingResult bindingResult, Map<String, Object> model){

        if(bindingResult.hasErrors()){
            List<Transport> transports = dao.getAll(Transport.class);
            model.put("transports", transports);
            return"tp/transport";
        }

        return "redirect:transport";
    }

    public void setDao(GenericDAO dao) {
        this.dao = dao;
    }
}
