package com.wannaride.utils;

import com.wannaride.dataAccess.GenericDAO;
import com.wannaride.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/write")
public class SimpleDaoTest extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(SimpleDaoTest.class);

    @Autowired
    @Qualifier("genericDAO")
    private GenericDAO dao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        log.debug("list of users requested");

        PrintWriter out = response.getWriter();

        out.println("<HTML><HEAD>");
        out.println("<TITLE>WANNARIDE</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("USERS");
        out.println("<br>");

        List<User> userList = dao.getAll(User.class);
        for (User user : userList) {
            out.println(user);
            out.println("<br>");
        }

        out.println("</BODY></HTML>");
        out.close();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
