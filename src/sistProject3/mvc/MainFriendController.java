package sistProject3.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sistProject3.database.Board_Dao;
import sistProject3.database.Main_Dao;
import sistProject3.page.BPiclistPageObject;
import sistProject3.page.BlistPageObject;
import sistProject3.vo.Members1;
import vo.Members;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet(name = "hmain2.do", urlPatterns = { "/hmain2.do" })
public class MainFriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFriendController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// # MVC를 통한 EMP 조회 처리.
		// 1. 요청
		//	1) 한글에 대한 encoding
	 	  HttpSession session = request.getSession(true);
	 	//로그인 세션  
	 	 Members1 member=  (Members1) session.getAttribute("mem");
		request.setCharacterEncoding("utf-8");
		// 넘긴값 바다오기
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null) mem_id = "";
		
		String accepter = request.getParameter("accepter");
		String pageStr = request.getParameter("page");
		String perPageNumStr = request.getParameter("perPageNum");
		
		// 사진 게시글
		String ppageStr = request.getParameter("ppage");
		String pperPageNumStr = request.getParameter("pperPageNum");
		
		// 2. 모델
		//mem_id = "HIGIRL";
		if(accepter == null) accepter = mem_id;
		if(pageStr == null || pageStr.equals("")) pageStr ="1";
		int cpage = Integer.parseInt(pageStr);
		if(perPageNumStr == null || perPageNumStr.equals("")) perPageNumStr ="4";
		int perPageNum = Integer.parseInt(perPageNumStr);
		// 사진 게시글
		if(ppageStr == null || ppageStr.equals("")) ppageStr ="1";
		int pcpage = Integer.parseInt(ppageStr);
		if(pperPageNumStr == null || pperPageNumStr.equals("")) pperPageNumStr ="4";
		int pperPageNum = Integer.parseInt(pperPageNumStr);
		
		// pageObject.jar 페이지 처리 객체를 생성하고 메서드 호출 
		// 게시글 게시물
		BlistPageObject blpageObject = new BlistPageObject(accepter, cpage, perPageNum);
		
		// 사진 게시물
		BPiclistPageObject bplPageObject = new BPiclistPageObject(accepter, pcpage, pperPageNum);
		
		// DB 처리하는 객체를 생성하고 메서드 호출
		Board_Dao dao = new Board_Dao();
		blpageObject.setTotalRow(dao.getTotalRow(blpageObject));
		blpageObject.setAccepter(accepter);
		// JSP에서 페이지네이션을 위해 아이디 조건으로 게시글 전체 데이터 개수 필요
		// 게시글
		request.setAttribute("blpageObject", blpageObject);
		// 사진 게시글
//		bplPageObject.setTotalRow(dao.getPtotalRow(bplPageObject));
//		bplPageObject.setAccepter(accepter);
//		request.setAttribute("bplPageObject", bplPageObject);
		
		// 게시글 게시물
		request.setAttribute("blist", dao.boardList(blpageObject));
		// 사진 게시물
		request.setAttribute("bplist", dao.bPicList(bplPageObject));
		request.setAttribute("boardCnt", dao.boardCnt(mem_id));
		request.setAttribute("follower", dao.follwerCnt(mem_id));
		request.setAttribute("following", dao.follwingCnt(mem_id));
		request.setAttribute("picList", dao.pictureList(mem_id));
		request.setAttribute("gbList", dao.gbookList(mem_id));
		
		
		//메인 왼쪽
		Main_Dao dao1 = new Main_Dao();
		
 
		request.setAttribute("mainName", dao1.mainName(mem_id));
		request.setAttribute("mainProfile", dao1.mainProfile(mem_id));
		Members1 mem = new Members1(mem_id);
			if(dao1.mainProfile(mem_id).getHome_no()==1) {
				System.out.println("안올라가!!");
			}
			else {
				dao1.updateToday_Hit(mem_id);
			}
		
	
		
		// 3. view처리
		// http://localhost:7080/sistProject3/hmain.do
		String page = "miniHome\\main.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);		
	}

}
