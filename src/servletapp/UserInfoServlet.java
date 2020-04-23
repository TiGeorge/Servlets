package servletapp;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream out = resp.getOutputStream();

        HttpSession session = req.getSession();

        UserInfo loginedInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);

        if (loginedInfo == null) {
            resp.sendRedirect(getServletContext().getContextPath() + "/login");
            return;
        }

        out.println("<html>");
        out.println("<head><title>Session example</title></head>");

        out.println("<body>");

        out.println("<h3>User Info:</h3>");

        out.println("<p>User Name:" + loginedInfo.getUserName() + "</p>");
        out.println("<p>Country:" + loginedInfo.getCountry() + "</p>");
        out.println("<p>Post:" + loginedInfo.getPost() + "</p>");

        out.println("</body>");
        out.println("<html>");

    }
}
