package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	public MemberDAO() {
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
	
	public void registerMember(Member member) throws SQLException {
		 Connection conn = connect();
		 String query = "INSERT INTO member VALUES(?,?,?)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, member.getId());
		 ps.setString(2, member.getPassword());
		 ps.setString(3, member.getName());
		 ps.executeUpdate();
		 close(ps, conn);
	 }
	
	public ArrayList<String> printAll() throws SQLException {
		 ArrayList<String> taglist = new ArrayList<>();
		 Connection conn = connect();
		 String query = "select * from mb join tag using (mb_id)";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			Member mb = new Member();
					mb.setId(rs.getString("id"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
		 }
		 close(rs, ps, conn);
		 return taglist;
	 }
	
	public Member print(String id) throws SQLException {
		 Connection conn = connect();
		 String query = "SELECT * FROM member WHERE id=?";
		 PreparedStatement ps = conn.prepareStatement(query);
		 ps.setString(1, id);
		 ResultSet rs = ps.executeQuery();
		 Member mb = null;
		 if(rs.next()) {
			 mb = new Member(rs.getString("id"),rs.getString("password"),
					 rs.getString("name"));
		 	}
		 return mb;
	 }
	
}
