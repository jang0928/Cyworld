package sistProject3.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistProject3.database.GuestbookDao;
import sistProject3.database.Main_Dao;
import sistProject3.vo.Bcomments;
import sistProject3.vo.Guestbook;

/**
 * Servlet implementation class GuestBookConDetail
 */
@WebServlet(name = "gbcdetail.do", urlPatterns = { "/gbcdetail.do" })
public class GuestBookConDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// http://localhost:8070/sistProject3/gbcdetail.do
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookConDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int gbook_no = 1;
		String gbook_noS = request.getParameter("gbook_no");
		if(gbook_noS !=null && !gbook_noS.equals("")) gbook_no = Integer.parseInt(gbook_noS);
		int home_no = 1;
		String home_noS = request.getParameter("home_no");
		if(gbook_noS != null && !home_noS.equals("")) home_no = Integer.parseInt(home_noS);
		System.out.println("##############����!!");
		
		GuestbookDao dao = new GuestbookDao();
		
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null) mem_id = "HIMAN";
		String com_content = request.getParameter("com_content");
		if(com_content == null) com_content = "";
		if(!com_content.equals("")) {
			Bcomments comm  = new Bcomments(0, gbook_no, mem_id, com_content, null);
			dao.insertGbComments(comm);
		}
		String gb_content  = request.getParameter("gb_content");
		if(gb_content == null) gb_content = "";
		String gb_constraint = request.getParameter("gb_constraint");
		if(gb_constraint==null) gb_constraint ="N";
		if(!gb_content.equals("")){	
			GuestbookDao dao2  = new GuestbookDao();
			dao2.insertGuestbook(new Guestbook(0,1, mem_id,gb_content,null,gb_constraint));
		}	
		System.out.println(home_no);
		System.out.println(dao.bookList(home_no).size());
		request.setAttribute("bookList", dao.bookList(home_no));
		request.setAttribute("bcomList", dao.bcomList(gbook_no));
		
		//硫��� �쇱そ
		Main_Dao dao1 = new Main_Dao();
		
		request.setAttribute("mainName", dao1.mainName("HIMAN"));
		request.setAttribute("mainProfile", dao1.mainProfile("HIMAN"));
		System.out.println("#########"+dao1.mainProfile("HIMAN").getHome_no());
			if(dao1.mainProfile("HIMAN").getHome_no()==1) {
				System.out.println("���щ�쇨�!!");
			}
			else {
				dao1.updateToday_Hit("HIMAN");
			}
		
		String page = "miniHome\\main_guestbook.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
