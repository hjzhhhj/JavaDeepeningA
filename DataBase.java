package day07_08_db;

import java.sql.*;

public class Database {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/dbstudy?serverTimezone=Asia/Seoul";
	String user = "root";
	String password = "1234";

	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			System.out.println("MySQL 서버 연동 성공");
		} catch (Exception e) {
			System.out.println("MySQL 서버 연동 실패 ~ " + e.toString());
		}
	}

	boolean loginCheck(String ii, String pp) {
		boolean flag = false;
		String id = ii;
		String pw = pp;
		try {
			String checkingStr = "SELECT password FROM members WHERE id='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			while (result.next()) {
				if (pw.equals(result.getString("password"))) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			flag = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
		return flag;
	}

	public void close() {
		try {
			if (stmt != null) stmt.close();
			if (con != null) con.close();
			System.out.println("MySQL 연결 종료");
		} catch (Exception e) {
			System.out.println("MySQL 연결 종료 실패 > " + e.toString());
		}
	}
}