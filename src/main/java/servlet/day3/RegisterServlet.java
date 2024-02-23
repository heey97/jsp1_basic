package servlet.day3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;
@WebServlet("/register.cc")
public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	private static final Logger Logger = LoggerFactory.getLogger(RegisterServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.info("[MyInfo]고객등록 화면 요청되었습니다!");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/register.jsp");
		dispatcher.forward(request, response);
	}
	
	//register.jsp 화면에서 입력된 값을 post 방식으로 전달 받기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TblCustomerDao dao = new TblCustomerDao();
		
		Logger.info("[MyInfo]고객등록 데이터 저장이 요청 되었습니다.");
		//POST : 요청값 인코딩 필수
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String temp = request.getParameter("age");
		//나이가 필수 입력이 아니라면 값이 비어있습니다. 그 때 parseInt 결과 확인합시다. => 오류
		int age = 0;
		
		//form 태그 요소의 name="age"가 있으므로 temp가 null 일 경우는 없습니다.
		if(temp.length() !=0) age = Integer.parseInt(temp);
		
		//dao의 메소드 인자로 전달할 vo 객체 생성하기
		CustomerVo vo = new CustomerVo(userid, name, email, age, null); 
								//reg_date는 sql insert문에서 sysdate를 찍어주기 때문에 null값 입력
		Logger.info("\t 입력 값 vo : {}",vo);
		dao.join(vo); // pk 중복값있으면 무결성 오류
		
		//서버가 클라이언트에게 응답을 보냅니다. "customer.cc로 요청을 보내라."
		//response.forward = 값을 들고 페이지만 변경
		//response.sendRedirect = 서버가 클라이언트에게 요청을 다시보내라고 응답
		//sendRedirect는 웹페이지의 js,out.println 출력을 못합니다. 
		response.sendRedirect("customers.cc");
	}
}
