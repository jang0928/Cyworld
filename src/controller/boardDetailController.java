package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board_Dao;
import vo.Board;
import vo.BoardAndMembers;

/**
 * Servlet implementation class boardDetailController
 */
@WebServlet(name = "boardDetail.do", urlPatterns = { "/boardDetail.do" })
public class boardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String proc = request.getParameter("proc"); //가장 중요
		String boardnoS = request.getParameter("boardno");
		if(boardnoS==null) boardnoS="1";
		int boardno = Integer.parseInt(boardnoS);
		if(proc==null) proc="";
		
		//2. 모델처리
		Board_Dao dao = new Board_Dao();
		BoardAndMembers br = dao.getBoard(boardno);
		System.out.println("###########" +br.BOARD_CONTENT);
		request.setAttribute("board", dao.getBoard(boardno));
		if(proc.equals("del")) {
			System.out.println("삭제 준비 완료 : " + boardno);
			dao.deleteBoard(boardno);
		}
		
		String page="admin\\board_detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
