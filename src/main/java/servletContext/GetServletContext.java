package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        List member = (ArrayList)context.getAttribute("member");

        if (context.getAttribute("member") == null) {
            out.print("<html><body>");
            out.print("member 정보가 없습니다.");
            out.print("</body></html>");
        } else {
            String name = (String)member.get(0);
            int age = (Integer)member.get(1);
            out.print("<html><body>");
            out.print(name +"<br>");
            out.print(age + "<br>");
            out.print("</body></html>");
        }

    }
}
