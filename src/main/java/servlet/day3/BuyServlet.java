package servlet.day3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblBuyDao;
import project.dao.TblCustomerDao;
import project.vo.BuyVo;
import project.vo.CustomerVo;


@WebServlet(urlPatterns={"/buys.cc"}, description = "구매 내역 조회")
public class BuyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger Logger = LoggerFactory.getLogger(BuyServlet.class);
	
	//고객 전체 조회 요청은 a 태그 메뉴 이므로 GET 방식 요청입니다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		TblBuyDao dao = new TblBuyDao();
		List<BuyVo> list = dao.selAll();

		Logger.info("[@.@]구매내역 전체조회 : {}",list);
		// 서블릿에서는 jdbc 관련된 실행하고 조회 결과는 jsp에서 웹페이지 작성합니다.
	    // 서블릿은 요청/응답 컨트롤러, jsp는 뷰(view)라고 부릅니다.
		
		//뷰 jsp에 애트리뷰트 값을 저장해서 보내기
		//pageContext는 하나의 웹페이지 범위,request 는 하나의 요청 범위로 애트리뷰트 저장
		request.setAttribute("list", list);
		
		////뷰 jsp로 '요청을 전달- 애트리뷰트 값 가져가기'하고 화면을 전환(forward)해야 합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/day3/buys.jsp");
		dispatcher.forward(request, response);
		//실행브라우저 url : http//localhost:8088/jsp1/customers.cc이고 화면의 웹페이지는 customers.jsp입니다.
	}
}
