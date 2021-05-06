package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board_Dao;
import vo.BoardAndMembers;

/**
 * Servlet implementation class boardController
 */
@WebServlet(name = "board.do", urlPatterns = { "/board.do" })
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	1) 한글에 대한 encoding
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		System.out.println("#내용 : "+content);

		//2. 모델
		//service 시작
		if(content==null) content="";
		
		//DB 접속 메서드를 통해 모델 데이터 처리
		//------dao 단계 시작
		Board_Dao dao = new Board_Dao();
		//------dao 단계 끝
		ArrayList<BoardAndMembers> List = dao.boardList(content);
		//======service 단계 끝======
		//DB에서 온 ArryaList<Board> 데이터를 모델명 memberList로 선언
		//이 모델명 memberList는 view 단에서 el ${memberList}로 활용	
		request.setAttribute("bList", dao.boardList(content));
		//3. view 처리
		String page ="admin\\board.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
