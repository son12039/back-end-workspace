package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		// 로딩 연결 DELETE emp_id로 삭제 쿼리문 삭제
		try {
			
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			Class.forName(ServerInfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection
					(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
			
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "222");
			
			System.out.println(ps.executeUpdate()+"명 삭제!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
