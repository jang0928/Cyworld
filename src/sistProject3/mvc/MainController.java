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


/**
 * Servlet implementation class BoardListController
 */
@WebServlet(name = "hmain.do", urlPatterns = { "/hmain.do" })
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// # MVC瑜� �듯�� EMP 議고�� 泥�由�.
		// 1. ��泥�
		//	1) ��湲��� ���� encoding
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
        
        Members1 member=  (Members1) session.getAttribute("mem");
        
		String accepter = request.getParameter("accepter");
		String pageStr = request.getParameter("page");
		String perPageNumStr = request.getParameter("perPageNum");
		
		// �ъ� 寃���湲�
		String ppageStr = request.getParameter("ppage");
		String pperPageNumStr = request.getParameter("pperPageNum");
		
		// 2. 紐⑤��
		//mem_id = "HIGIRL";
		if(accepter == null) accepter = member.getMem_id();
		if(pageStr == null || pageStr.equals("")) pageStr ="1";
		int cpage = Integer.parseInt(pageStr);
		if(perPageNumStr == null || perPageNumStr.equals("")) perPageNumStr ="4";
		int perPageNum = Integer.parseInt(perPageNumStr);
		// �ъ� 寃���湲�
		if(ppageStr == null || ppageStr.equals("")) ppageStr ="1";
		int pcpage = Integer.parseInt(ppageStr);
		if(pperPageNumStr == null || pperPageNumStr.equals("")) pperPageNumStr ="4";
		int pperPageNum = Integer.parseInt(pperPageNumStr);
		
		// pageObject.jar ���댁� 泥�由� 媛�泥대�� ���깊��怨� 硫����� �몄� 
		// 寃���湲� 寃���臾�
		BlistPageObject blpageObject = new BlistPageObject(accepter, cpage, perPageNum);
		
		// �ъ� 寃���臾�
		BPiclistPageObject bplPageObject = new BPiclistPageObject(accepter, pcpage, pperPageNum);
		
		// DB 泥�由ы���� 媛�泥대�� ���깊��怨� 硫����� �몄�
		Board_Dao dao = new Board_Dao();
		// JSP���� ���댁��ㅼ�댁���� ���� ���대�� 議곌굔�쇰� 寃���湲� ��泥� �곗�댄�� 媛��� ����
		// 寃���湲�
		blpageObject.setTotalRow(dao.getTotalRow(blpageObject));
		request.setAttribute("blpageObject", blpageObject);
		blpageObject.setAccepter(accepter);
		// �ъ� 寃���湲�
		bplPageObject.setTotalRow(dao.getPtotalRow(bplPageObject));
		bplPageObject.setAccepter(accepter);
		request.setAttribute("bplPageObject", bplPageObject);
		
		// 寃���湲� 寃���臾�
		request.setAttribute("blist", dao.boardList(blpageObject));
		
		// �ъ� 寃���臾�
		request.setAttribute("bplist", dao.bPicList(bplPageObject));
		request.setAttribute("boardCnt", dao.boardCnt(member.getMem_id()));
		request.setAttribute("follower", dao.follwerCnt(member.getMem_id()));
		request.setAttribute("following", dao.follwingCnt(member.getMem_id()));
		request.setAttribute("picList", dao.pictureList(member.getMem_id()));
		request.setAttribute("gbList", dao.gbookList(member.getMem_id()));
		
		
		//硫��� �쇱そ
		Main_Dao dao1 = new Main_Dao();
		
		request.setAttribute("mainName", dao1.mainName(member.getMem_id()));
		request.setAttribute("mainProfile", dao1.mainProfile(member.getMem_id()));
		System.out.println("#########"+dao1.mainProfile(member.getMem_id()).getHome_no());
			if(dao1.mainProfile(member.getMem_id()).getHome_no()==1) {
				System.out.println("안올라가");
			}
			else {
				dao1.updateToday_Hit(member.getMem_id());
			}
		
			 // 로그아웃
//		      String logout = request.getParameter("logout");
//
//		      if(logout != null && logout.equals("y")){
//		         
//		           session.invalidate();
//		           response.sendRedirect("/sessLogin.do");
//		      }
//	
		
		// 3. view泥�由�
		// http://localhost:7080/sistProject3/hmain.do
		String page = "miniHome\\main.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);		
	}

}
