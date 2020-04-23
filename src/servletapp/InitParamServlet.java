package servletapp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitParamServlet extends HttpServlet {

    private String emailSupport1;

    public InitParamServlet() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Получить значение параметра инициализирования (initialization parameter) Servlet.
        // (По конфигурации данный Servlet в web.xml).
        emailSupport1 = config.getInitParameter("emailSupport1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Получить значение параметра инициализирования (initialization parameter) другим способом.
        String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");

        ServletOutputStream out = resp.getOutputStream();

        out.println("<html>");
        out.println("<head><title>Init Param</title></head>");

        out.println("<body>");
        out.println("<h3>Init Param</h3>");
        out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        out.println("</body>");
        out.println("<html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
