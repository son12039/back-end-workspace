package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TXCommitTest {

	public static void main(String[] args) {
		
		 
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
			
			// 3. PreparedStatement + 쿼리문
			String query1 = "INSERT INTO member VALUES(?,?,?)";
			String query2 = "SELECT * FROM member WHERE id=?";
		
			// 트랜잭션 시작...!
			conn.setAutoCommit(false);
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, "10");
			ps1.setString(2, "passt");
			ps1.setString(3, "테스뷰");
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, "9");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) { // 존재
				conn.rollback();
				System.out.println("취소");
			} else { // 비존재
				conn.commit();
				System.out.println("추가");
			}
			
			// 트랜잭션 끝! 다시 원래대로 돌려놓음
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
