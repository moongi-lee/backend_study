package sec01.ex01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

    public void init() {
        System.out.println("init 메서드 호출");
    }

    public void destroy() {
        System.out.println("destroy 메서드 호출");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet 메서드 호출");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        String data = "<html>";
        data += "<body>";
        data += "아이디: " + user_id;
        data += "<br>";
        data += "비밀번호: " + user_pw;
        data += "</body>";
        data += "</html>";
        out.print(data);

    }

}
