package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Main_Dao;

/**
 * Servlet implementation class mainController
 */
@WebServlet(name = "main.do", urlPatterns = { "/main.do" })
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");		
		
		Main_Dao dao = new Main_Dao();
		request.setAttribute("mList", dao.mList(null));
		request.setAttribute("bList", dao.bList(null));
		request.setAttribute("bgList", dao.bgList(null));
		request.setAttribute("fList", dao.fList(null));
		
		String page="admin\\main.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
