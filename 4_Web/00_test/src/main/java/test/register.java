package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		try {
			registerMember(id, pwd, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	 public boolean registerMember(String id, String password, String name) throws SQLException {
		 Connection conn = connect();
		 String query = "INSERT INTO member VALUES(?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, id);
		 ps.setString(2, password);
		 ps.setString(3, name);
		 int a = ps.executeUpdate();
		 
		 close(ps, conn);
		 return a==1;
	 }
	 
	 
	 public register() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	 
	 
	 
	 
		public Connection connect() throws SQLException {
			return DriverManager.getConnection
					("jdbc:mysql://localhost:3306/tagtest","root","qwer1234");
		}
		public void close(PreparedStatement ps, Connection conn) throws SQLException {
			ps.close();
			conn.close();
		}
		public void close(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
			rs.close();
			close(ps,conn);
		}
}
