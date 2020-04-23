package servletapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {

    // Request:
    // http://localhost:8080/ServletTutorial/other/forwardDemo?forward=true
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Получить значение параметра (parameter) на URL.
        String forward = request.getParameter("forward");

        if ("true".equals(forward)) {
            System.out.println("Forward to ShowMeServlet");

            // Натроить данные в атрибут (attribute) request (запроса).
            request.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, //
                    "Hi, I'm Tom come from Walt Disney !");

            RequestDispatcher dispatcher //
                    = request.getServletContext().getRequestDispatcher("/showMe");
            dispatcher.forward(request, response);

            return;
        }
        ServletOutputStream out = response.getOutputStream();
        out.println("<html>");
        out.println("<h3>Text of ForwardDemoServlet</h3>");
        out.println("- servletPath=" + request.getServletPath());
        out.println("<html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
