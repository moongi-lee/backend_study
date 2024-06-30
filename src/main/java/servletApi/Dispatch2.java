package servletApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatch2")
public class Dispatch2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // out.println("<html><body>");
        // out.println("dispatch를 이용한 forward 실습입니다.");
        // out.println("</body></html>");

        String name=request.getParameter("name");
        String address = (String) request.getAttribute("address");
        out.println("<html><body>");
        out.println("주소:" + address);
        out.println("이름:"+name);
        out.println("<br>");
        out.println("dispatch를 이용한 forward 실습입니다.");
        out.println("</body></html>");

    }
}
