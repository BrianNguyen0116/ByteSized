import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AdminServletTest {

    @Test
    public void testDoGetWithValidSession() throws Exception {
        // Setup
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("admin");
        when(request.getRequestDispatcher("/admin-page.jsp")).thenReturn(dispatcher);

        // Execute
        AdminServlet servlet = new AdminServlet();
        servlet.doGet(request, response);

        // Verify
        verify(request).getRequestDispatcher("/admin-page.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoGetWithInvalidSession() throws Exception {
        // Setup
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession(false)).thenReturn(null);

        // Execute
        AdminServlet servlet = new AdminServlet();
        servlet.doGet(request, response);

        // Verify
        verify(response).sendRedirect("/login.jsp");
    }

    @Test
    public void testDoPostCreatePizza() throws Exception {
        // Setup
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("admin");
        when(request.getParameter("action")).thenReturn("createPizza");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Execute
        AdminServlet servlet = new AdminServlet();
        servlet.doPost(request, response);

        // Verify
        verify(response).sendRedirect("/admin");
        
    }

    @Test
    public void testDoPostInvalidAction() throws Exception {
        // Setup
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("admin");
        when(request.getParameter("action")).thenReturn("invalidAction");

        // Execute
        AdminServlet servlet = new AdminServlet();
        servlet.doPost(request, response);

        // Verify
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST);
    }



}
