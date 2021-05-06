package sistProject3.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistProject3.database.Main_Dao;
import sistProject3.database.ProfileDao;

/**
 * Servlet implementation class profileController
 */
@WebServlet(name = "pro.do", urlPatterns = { "/pro.do" })
public class profileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// http://localhost:8070/sistProject3/pro.do
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int home_no = 1;
		String home_noS = request.getParameter("home_no");
		String mem_id = request.getParameter("mem_id");
		if(mem_id == null) mem_id = "HIMAN";
		
		ProfileDao dao = new ProfileDao(); 
		request.setAttribute("proList", dao.proList(mem_id, home_no));
		
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
		
		String page = "miniHome\\main_profile.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
