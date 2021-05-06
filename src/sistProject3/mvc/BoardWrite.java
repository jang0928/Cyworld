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
import sistProject3.vo.Board;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet(name = "bWrite.do", urlPatterns = { "/bWrite.do" })
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// 1. 요청값
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null) mem_id = "HIMAN";
		String board_title = request.getParameter("board_title");
		if(board_title == null) board_title = "";
		String board_like = request.getParameter("board_like"); 
		if(board_like == null || board_like.trim().equals("")) board_like = "0";
		String board_content = request.getParameter("board_content");
		if(board_content == null) board_content = "";
		String board_picture = request.getParameter("board_picture");
		if(board_picture == null) board_picture = "";
		// 입력 객체 생성 및 초기화면 구분
		if(!board_title.equals("")){
			Board_Dao dao = new Board_Dao();
			dao.insertBoard(new Board(0, mem_id, board_title, new Integer(board_like), board_content, null, board_picture));
		}
		
		Main_Dao dao1 = new Main_Dao();
		request.setAttribute("mainName", dao1.mainName("HIMAN"));
		request.setAttribute("mainProfile", dao1.mainProfile("HIMAN"));
		
		
		// 3. view호출.
		String page = "miniHome\\main_board_write.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
