package sistProject3.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistProject3.database.Board_Dao;
import sistProject3.database.Main_Dao;
import sistProject3.vo.Comments;
/**
 * Servlet implementation class BoardConDetail
 */
@WebServlet(name = "boardConDetail.do", urlPatterns = { "/boardConDetail.do" })
public class BoardConDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardConDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int board_no = 0;
		String board_noS = request.getParameter("board_no");
		if(board_noS != null && !board_noS.equals("")) board_no = Integer.parseInt(board_noS);
		

		Board_Dao dao = new Board_Dao();

		// 댓글 등록 위 board_no 포함
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null) mem_id = "HIMAN";
		String com_content = request.getParameter("com_content");
		if(com_content == null) com_content = "";
		if(!com_content.equals("")){
			Comments comm  = new Comments(0, board_no, mem_id, com_content, null);
			dao.insertComments(comm);
		}
		
		request.setAttribute("bcd", dao.getBoardCD(board_no));
		request.setAttribute("bcomList", dao.bcomList(board_no));
		Main_Dao dao1 = new Main_Dao();
		// JSP에서 페이지네이션을 위해 아이디 조건으로 게시글 전체 데이터 개수 필요
		//mainProfile
 
		
		request.setAttribute("mainName", dao1.mainName("HIMAN"));
		request.setAttribute("mainProfile", dao1.mainProfile("HIMAN"));
		
		
		
		String page = "miniHome\\main_board_cont.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
