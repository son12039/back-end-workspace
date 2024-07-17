package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	public static void main(String[] args) {

		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection
			(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
						 		
			
			// 3. PrepareStatememt - 쿼리 : UPDATE (emp_id 선택해서 emp_name 변경)
			String query = "UPDATE employee SET emp_name = ? where emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "박성철");
			ps.setInt(2, 900);
			
			System.out.println(ps.executeUpdate()+"명 수정!");
			
			
			
			
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		


	}

}
