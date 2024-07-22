package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String gen = (request.getParameter("gender")).charAt(0)=='F' ? "여자" : "남자";
			
		String[] menu = request.getParameterValues("menu");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다..</h1>");
		out.println("<P>당신의 아이디는 "+ userId +"</P>");
		out.println("<P>당신의 비밀번호는 "+ userPwd +"</P>");
		out.println("<p>당신의 성별은 "+ gen +"</p>");
		out.println("<ul>");
		for(String m : menu) {
			out.println("<li> "+ m +"</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}

}
