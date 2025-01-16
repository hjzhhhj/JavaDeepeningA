package InT2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {
    public Connection con;           
    public Statement stmt = null;    
    public PreparedStatement psmt;   
    public ResultSet rs;             

    public JDBConnection() {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shopdb", "root", "1234");

            System.out.println("연결 성공");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from member");
            printDate(rs, "id", "name", "addr");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }
    }

    private static void printDate(ResultSet rs, String col1, String col2, String col3) throws SQLException {
        while (rs.next()) {
            if (!col1.isEmpty()) {
                System.out.print(rs.getString(col1));
            }
            if (!col2.isEmpty()) {
                System.out.print("\t|\t" + rs.getString(col2));
            }
            if (!col3.isEmpty()) {
                System.out.println("\t|\t" + rs.getString(col3));
            }
        }

    }

    // 메인 메서드
    public static void main(String[] args) {
    	JDBConnection jdbc = new JDBConnection();
    }
}