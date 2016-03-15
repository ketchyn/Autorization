package servlets;

import Annotations.Inject;
import Inicializators.Initialize;
import Inicializators.ReflectionFieldsDeployer;
import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersServlet extends SessionsServlet {
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) //todo: remove after module 2 home work


    public UsersServlet() {

    }

    //get public user profile
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work
    }

    //sign up
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        System.out.println(dbService.toString());
        String login = request.getParameter("login");

        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        UserProfile user =  new UserProfile(login, pass, email);
        if(accountService.getUserByLogin(login)==null){

            accountService.addNewUser(user);
            response.getWriter().print(" registred");
        } else   response.getWriter().print(" allready registred");


    }

    //change profile
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work
    }

    //unregister
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work
    }
}
