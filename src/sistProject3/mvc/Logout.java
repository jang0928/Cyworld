package sistProject3.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet(name = "logout.do", urlPatterns = { "/logout.do" })
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//session.invalidate();
		String logout = request.getParameter("logout");

	      if(logout != null && logout.equals("y")){
	         
	           session.invalidate();
	      }
		
		RequestDispatcher rd = request.getRequestDispatcher("/sessLogin.do");
		rd.forward(request, response);	
	}

}
