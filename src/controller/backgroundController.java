package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Background_Dao;
import vo.Background;

/**
 * Servlet implementation class backgroundController
 */
@WebServlet(name = "background.do", urlPatterns = { "/background.do" })
public class backgroundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public backgroundController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		Background_Dao dao = new Background_Dao();
		request.setAttribute("bgList", dao.bgList(null));

		
		String bgname = request.getParameter("bgname");
		if(bgname==null) bgname="";
		
		String bgurl = request.getParameter("bgurl");
		if(bgurl==null) bgurl="";

		
		if(!bgname.equals("")) {
			//Background_Dao dao1 =new Background_Dao();
			dao.insertBG(new Background(bgname, bgurl));
		}
		
		
		String page="admin\\background.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
