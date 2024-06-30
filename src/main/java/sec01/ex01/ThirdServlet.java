package sec01.ex01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init 메서드 호출");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 메서드 호출");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doGet 메서드 호출");
    }
}
