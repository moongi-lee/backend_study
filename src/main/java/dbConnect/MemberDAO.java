package dbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/bbmc";
    private static final String user = "moongi";
    private static final String pwd = "dlansrl12!";
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    public MemberDAO() {
        System.out.println("MemberDAO 생성자 호출");
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<MemberVO>();
        try {
            connDB();
            String query = "select * from t_member ";
            System.out.println(query);
            
            // 일반 statement 사용 -> 단순문자열을 전달 -> dbms에서 직접 컴파일 후 사용
            // ResultSet rs = stmt.executeQuery(query);

            // prepared statement 사용 -> java에서 미리 컴파일하여 dbms에 전달
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void connDB() {
        try {
            Class.forName(driver);
            System.out.println("MySql 드라이버 로딩 성공");
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection 생성 성공");
            stmt = con.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (Exception e) {
            System.out.println("MySql 드라이버 로딩 실패");
            e.printStackTrace();
        }
    }
}
