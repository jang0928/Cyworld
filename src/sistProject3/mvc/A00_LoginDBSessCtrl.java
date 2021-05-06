package sistProject3.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sistProject3.database.A00_Dao;
import sistProject3.vo.Members1;

/**
 * Servlet implementation class A00_LoginDBSessCtrl
 */
@WebServlet(name = "sessLogin.do", urlPatterns = { "/sessLogin.do" })
public class A00_LoginDBSessCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A00_LoginDBSessCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. ��泥�媛� 泥�由�
	    String mem_id = request.getParameter("mem_id");
	    String mem_pass = request.getParameter("mem_pass");
	    
	    // 2. 紐⑤�� �곗�댄�� 泥�由�
	    //   1) 珥�湲� ���댁� - 珥�湲� 濡�洹몄�� ���댁� �ㅼ��
	    //   2) ���� �� ���댁� - ���� �� ������ �� ���댁� �ㅼ��
	    if(mem_id==null) mem_id="";
	     if(mem_pass==null) mem_pass=""; 
	     
	      //String page="";
	     String page="miniHome\\login.jsp";
	      
	      if(!mem_id.equals("") && !mem_pass.equals("")) {
	    	  A00_Dao dao=new A00_Dao();
	          Members1 mem=dao.login(new Members1(mem_id, mem_pass));
	          //  	     
//	 	     String page="/login.jsp";
	          if(mem!=null) {
	             request.setAttribute("isSuccess", true);
	             // DB �곕���� 寃쎌��, session 媛��� �ㅼ���댁�� model �곗�댄�곕�� 留ㅽ������.
	             // HttpSession session = request.getSession();
	             // session.setAttribute("member", dao.login(id,pass));
	             HttpSession session = request.getSession();
	             session.setAttribute("mem", mem);
	             if(mem.getMem_id().equals("MASTER")||mem.getMem_id().equals("STAFF")) {
	            	 page="/main.do";
	            	 
	             }else{
	            	 page= "/hmain.do";
	             }
	             
	             // String page="/login.jsp";
	           }else {
	              request.setAttribute("isSuccess", false);
	           }
	        }
	       
	       // 3. ��硫대�� �몄�  
	       // http://localhost:7080/sistProject3/sessLogin.do
	       RequestDispatcher rd=request.getRequestDispatcher(page);
	       rd.forward(request,response);
	    
	      
	}

}
