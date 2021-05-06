package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Font_Dao;
import vo.Font;

/**
 * Servlet implementation class fontController
 */
@WebServlet(name = "font.do", urlPatterns = { "/font.do" })
public class fontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		Font_Dao dao = new Font_Dao();
		request.setAttribute("fontList", dao.fontList(null));
		
		String fontname = request.getParameter("fontname");
		if(fontname==null) fontname="";
		
		String fonturl = request.getParameter("fonturl");
		if(fonturl==null) fonturl="";
		
		String fontfamily = request.getParameter("fontfamily");
		if(fontfamily==null) fontfamily="";
		
		if(!fontname.equals("")) {
			dao.insertFont(new Font(fontname,fonturl,fontfamily));
		}
		
		String page="admin\\font.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
