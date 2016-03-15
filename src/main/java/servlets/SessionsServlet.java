package servlets;

import Annotations.Inject;

import Inicializators.Initialize;
import Inicializators.ReflectionFieldsDeployer;
import Xquery.xQueryTester;
import accounts.AccountService;
import dbService.DBService;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xquery.XQException;
import java.io.FileNotFoundException;
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
public class SessionsServlet extends HttpServlet {

//maybe replace in constructor
    @Inject("DBService")
    protected static DBService dbService;

    protected static   AccountService accountService;
    public int a;

    @Override
    public void init(ServletConfig config) throws ServletException {
        List<Field> list = ReflectionFieldsDeployer.deploy(this.getClass());
       Initialize.run(list,this);
        accountService = new AccountService(dbService);
        }


    public  SessionsServlet() {

       something();
    }

    public void something(){
        ///

    }



    //get logged user profile
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
    /*    String sessionId = request.getSession().getId();
        UserProfile profile = accountService.getUserBySessionId(sessionId);
        if (profile == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            Gson gson = new Gson();
            String json = gson.toJson(profile);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(json);
            response.setStatus(HttpServletResponse.SC_OK);
        }*/
    }

    //sign in
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
      String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if ((login !=null || pass != null)) {
            if ( accountService.getUserByLogin(login)!=null) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().print(" You hava allready   registred");


            } else  response.sendRedirect("/register/index.html");

        }


       /* UserProfile profile = accountService.getUserByLogin(login);
        if (profile == null || !profile.getPass().equals(pass)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        accountService.addSession(request.getSession().getId(), profile);
        Gson gson = new Gson();
        String json = gson.toJson(profile);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
        response.setStatus(HttpServletResponse.SC_OK);*/
    }

    //sign out

}
