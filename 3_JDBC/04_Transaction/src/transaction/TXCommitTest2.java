package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/member","root","qwer1234");
			
			conn.setAutoCommit(false);
			
			/*
			 * 동엽 -> 동호 : 3만원씩 이체
			 * 동엽님의 잔액이 마이너스가 되면 이제 취소가 되어야 함!
			 * */
			// 3개 필요! UPDATE 2개 -> SELECT 1개
			String query1 = "UPDATE bank SET balance=balance+? WHERE name=?";
			String query2 = "UPDATE bank SET balance=balance+? WHERE name=?";
			String query3 = "SELECT balance FROM bank WHERE name=? AND balance>=30000";		
			PreparedStatement ps1 = conn.prepareStatement(query1),
			ps2 = conn.prepareStatement(query2),
			ps3 = conn.prepareStatement(query3);			
			ps3.setString(1, "동엽");
			ResultSet rs =ps3.executeQuery();			
			if(rs.next()) {
				ps1.setString(1, "-30000");
				ps1.setString(2, "동엽");
				ps1.executeUpdate();		
				ps2.setString(1, "30000");
				ps2.setString(2, "동호");
				ps2.executeUpdate();
				System.out.println("이체 성공");
				System.out.println("동엽의 이체 후 남은 잔액 : " +(rs.getInt("balance")-30000));
//				conn.commit();
			}else {
				System.out.println("이제 실패");
//				conn.rollback()
			}
			
			// 잔액이 없으므로 이체 취소!
			// 잔액이 있으므로 이체 성공!
			
			
			
			
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
