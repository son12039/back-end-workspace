package person.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import person.controller.PersonController;
import person.model.Person;

public class PersonTest {

	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonTest pt = new PersonTest();

		try {
			pt.searchAllPerson();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 이 부분은 테스트 용도로만!
	}

	// 각 Controller에 메서드들 연결하는 건 각 메서드들에서 구현

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson() throws SQLException {
		System.out.print("성함입력 : ");
		String name = sc.nextLine();
		System.out.print("나이입력 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("주소입력 : ");
		String addr = sc.nextLine();
		boolean ch = pc.addPerson(name, age, addr);
		System.out.println(ch ? name + "님, 회원 가입 완료!" : "정보입력오류");
		// ~~님, 회원 가입 완료!

	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() throws SQLException {
		System.out.print("변경 대상 아이디 입력 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("변경할 성함입력 : ");
		String name = sc.nextLine();
		System.out.print("변경할 나이입력 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("변경할 주소입력 : ");
		String addr = sc.nextLine();
		boolean ch = pc.updatePerson(id, name, age, addr);
		System.out.println(ch ? name + "님 데이터수정 완료!" : "없는 사람임!");
	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() throws SQLException {
		System.out.print("삭제할 아이디 입력 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println(pc.removePerson(id) ? "아이디 : " + id +"님 회원탈퇴 완료!" : "없는 사람임!");
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson() throws SQLException {
		System.out.print("검색할 아이디 입력 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println(pc.searchPerson(id));
	}

}
