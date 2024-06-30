package servletApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;


@WebServlet("/memberview")
public class MemberView extends HttpServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        List membersList = (List) request.getAttribute("membersList");
        out.print("<html><body>");
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td >삭제</td></tr>");
        for (int i = 0; i < membersList.size(); i++) {
            MemberVO memberVO = (MemberVO) membersList.get(i);
            String id = memberVO.getId();
            System.out.println("id: " + id);
            String pwd = memberVO.getPwd();
            System.out.println("pwd: " + pwd);
            String name = memberVO.getName();
            System.out.println("name: " + name);
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
                    + joinDate + "</td><td>" + "<a href='/member3?command=delMember&id=" + id
                    + "'>삭제 </a></td></tr>");

        }
        out.print("</table></body></html>");
        out.print("<a href='/memberForm.html'>새 회원 등록하기</a");
    }
}
