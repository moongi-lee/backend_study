package sec01.ex01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void init() {
        System.out.println("init 메서드 호출");
    }

    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        System.out.println("아이디: " + user_id);
        System.out.println("비밀번호: " + user_pw);
    }

    public void destroy() {
        System.out.println("destroy 메서드 호출");
    }

}
