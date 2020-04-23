package servletapp;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream out = resp.getOutputStream();

        HttpSession session = req.getSession();

        UserInfo loginedInfo = new UserInfo("Goga", "Russia", 5);

        session.setAttribute(Constants.SESSION_USER_KEY, loginedInfo);

        out.println("<html>");
        out.println("<head><title>Session example</title></head>");

        out.println("<body>");
        out.println("<h3>You are logined!, info stored in session</h3>");

        out.println("<a href='userInfo'>View User Info</a>");
        out.println("</body>");
        out.println("<html>");

    }
}
