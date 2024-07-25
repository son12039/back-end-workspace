package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.vo.Member;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("info");
		System.out.println(member);
		// request
		String product = (String) request.getAttribute("product");
		System.out.println(product);
		
		// 로그아웃! 세션정보숨통끊기
		session.invalidate();
		response.sendRedirect("index.jsp");// 로그인페이지로
	}

}
