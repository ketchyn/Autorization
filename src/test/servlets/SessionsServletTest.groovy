package servlets

import Inicializators.ReflectionFieldsDeployer
import accounts.AccountService
import dbService.DBService
import javafx.beans.binding.When
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor

import javax.servlet.ServletConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static junit.framework.Assert.*
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;

/**
 * Created by Alexandr on 23.02.2016.
 */
class SessionsServletTest  {
    private SessionsServlet sessionsServlet;
    private DBService dbServiceMock
    private AccountService accountServiceMock;
    private ReflectionFieldsDeployer reflectionFieldsDeployer;
    private HttpServletRequest requestMock;
    private HttpServletResponse responseMock;
    SessionsServlet servlet;



    @Before
    void setUp() {
         dbServiceMock = mock(dbService.DBService.class)
        accountServiceMock = mock(accounts.AccountService.class)
        requestMock = mock(HttpServletRequest.class)
        responseMock = mock(HttpServletResponse.class)
         servlet = new SessionsServlet();
       // spy.destroy();
    }


    @Test
    void testInit() {


    }
    @Test
    void testDoPost() {

    }
    @Test
    void isInitInvoke() {
        SessionsServlet spy = spy(servlet);
        ServletConfig a = null;
       verify(spy, never()).init(a);
      assertThat(spy.accountService, equalTo(null));
        spy.destroy();


    }


@Test
void isSomethingnvoke() {
   // SessionsServlet ser = new SessionsServlet();
    SessionsServlet spy = spy(new SessionsServlet());
 verify(spy,times(1)).something();


}


    @Test
    void isConstructorInvoked() {
        SessionsServlet spy = spy(servlet);
        assertEquals(spy.a,5);
        spy.destroy();

    }

    @Test
    void doPost_Condition_IsNull_Check() {
        servlet.accountService=accountServiceMock;
        when(accountServiceMock.getUserByLogin(anyString())).thenReturn(null);
        when(requestMock.getParameter("login")).thenReturn("login m");
        when(requestMock.getParameter("password")).thenReturn("password");
        doNothing().when(responseMock).sendRedirect(anyString());
      servlet.doPost(requestMock,responseMock)

        verify(responseMock,times(1)).sendRedirect("/register/index.html");

    }





}
