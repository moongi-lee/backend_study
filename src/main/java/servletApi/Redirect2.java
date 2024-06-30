package servletApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect2")
public class Redirect2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String address = (String) request.getAttribute("address");
        out.println("<html><body>");
        out.println("주소는 " + address + "입니다.");
        out.println("이름은 " + name + "입니다.");
        out.println("sendRedirect를 이용한 redirect 실습입니다.");
        out.println("</body></html>");
    }
}
