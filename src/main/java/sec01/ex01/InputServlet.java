package sec01.ex01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;


@WebServlet("/input")
public class InputServlet extends HttpServlet {


    public void init() {
        System.out.println("init 메서드 호출");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        System.out.println("아이디: " + user_id);
        System.out.println("비밀번호: " + user_pw);

        String[] subject = request.getParameterValues("subject");

        for (String string : subject) {
            System.out.println("선택한 과목: " + string);
        }


        Enumeration<String> enumeration = request.getParameterNames();

        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                System.out.println("name=" + name + ", value=" + value);
            }
        }


    }

}
