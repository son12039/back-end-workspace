package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import person.model.Person;


public class PersonController {

	// 리턴 타입이나 매개변수 자유롭게 변경 가능
	// 메서드 추가 가능
	/*
	 * 로딩 연결 PrepareStatement - 쿼리 실행
	 * 
	 */

	public PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)

	// person 테이블에 데이터 추가 - INSERT
	public boolean addPerson(String name, int age, String addr) throws SQLException {

		Connection conn = getConnect();

		String query = "INSERT INTO person(name, age, addr) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);

		return ps.executeUpdate()==1;
	}

	// person 테이블에 데이터 수정 - UPDATE
	public boolean updatePerson(int id, String name, int age, String addr) throws SQLException {

		Connection conn = getConnect();

		String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		ps.setInt(4, id); 
		return ps.executeUpdate()==1;
	}

	// person 테이블에 데이터 삭제 - DELETE
	public boolean removePerson(int id) throws SQLException {

		Connection conn = getConnect();

		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		return ps.executeUpdate()==1;

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public  ArrayList<Person> searchAllPerson() throws SQLException {

		Connection conn = getConnect();

		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

	    ArrayList<Person> list = new ArrayList<>();
		String all = "";
		while (rs.next()) {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setAge(rs.getInt("age"));
			person.setAddr(rs.getString("addr"));
			list.add(person);
		}
		
		closeAll(rs, ps, conn);
		
		return list;
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public String searchPerson(int id) throws SQLException {

		Connection conn = getConnect();

		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int Id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
			if (id == rs.getInt("id")) {
				return "아이디 " + Id + "님의 정보를 불러옵니다 " + "성함: " + name + " 나이: " + age + " 주소: " + addr;
			}
		}
		return "없는 친구";
	}

}
