import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check if the user is logged in as an admin
        if (session != null && session.getAttribute("role").equals("admin")) {
            // Render the admin page
            request.getRequestDispatcher("/admin-page.jsp").forward(request, response);
        } else {
            // Redirect the user to the login page
            response.sendRedirect("/login.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check if the user is logged in as an admin
        if (session != null && session.getAttribute("role").equals("admin")) {
            // Process the admin request
            String action = request.getParameter("action");
            if (action.equals("createPizza")) {
                // Create a new pizza in the database
                // Redirect the user back to the admin page
                response.sendRedirect("/admin");
            } else if (action.equals("deletePizza")) {
                // Delete a pizza from the database
                // Redirect the user back to the admin page
                response.sendRedirect("/admin");
            } else {
                // Invalid action parameter
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            // Redirect the user to the login page
            response.sendRedirect("/login.jsp");
        }
    }
}
