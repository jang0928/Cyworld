package sistProject3.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistProject3.database.A00_Dao;
import sistProject3.vo.Members1;

/**
 * Servlet implementation class A00_MemFindId
 */
@WebServlet(name = "memId.do", urlPatterns = { "/memId.do" })
public class A00_MemFindId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A00_MemFindId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// # MVC를 통한 EMP 조회 처리
		// 1. 요청
		// 1-1). 한글에 대한 encoding
		request.setCharacterEncoding("UTF-8");
		
		String mem_pnumber = request.getParameter("mem_pnumber");
		
		// 데이터가 정상적으로 나오는지 확인
		System.out.println("## 휴대폰 번호 : " + mem_pnumber);
		
		// 2. 모델
		if(mem_pnumber == null) mem_pnumber = "";
		
		// DB 접속에 메서드를 통해서 모델 데이터 처리
		A00_Dao dao = new A00_Dao();
		
		//ArrayList<Members> mlist = dao.memList(mem_pnumber);
		
		request.setAttribute("memList", dao.memList(mem_pnumber));
		
		// 3. view 처리
		// http://localhost:7080/sistProject3/memId.do
		String page = "miniHome\\find_id02.jsp";
				
		RequestDispatcher rd = request.getRequestDispatcher(page);
				
		rd.forward(request, response);

	}

}
