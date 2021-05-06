package sistProject3.mvc;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistProject3.database.A00_Dao;
import sistProject3.vo.Members1;




/**
 * Servlet implementation class A00_MemInsController
 */
@WebServlet(name = "memInsert.do", urlPatterns = { "/memInsert.do" })
public class A00_MemInsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A00_MemInsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("### 입력 ##");
		// 1. 요청값
		request.setCharacterEncoding("UTF-8");
		/*
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private String mem_birth2;   // 생일 입력
	private String mem_pnumber;
	private String mem_email;
	private String mem_address;
	private String gender;
		*/
		String mem_id = request.getParameter("mem_id");      
		String mem_pass = request.getParameter("mem_pass"); 
		String mem_name = request.getParameter("mem_name");   
		String mem_birth2 = request.getParameter("mem_birth2");   
		String mem_pnumber = request.getParameter("mem_pnumber");   
		String mem_email = request.getParameter("mem_email");   
		String mem_address = request.getParameter("mem_address"); 
		String gender = request.getParameter("gender"); 

		if(mem_id == null) mem_id = "";
		if(mem_pass == null) mem_pass = "";
		if(mem_name == null) mem_name = "";
		if(mem_birth2 == null) mem_birth2 = "";
		if(mem_pnumber == null) mem_pnumber = "";
		if(mem_email == null) mem_email = "";
		if(mem_address == null) mem_address = "";
		if(gender == null) gender = "";

		log("mem_id : " + mem_id);
		log("mem_pass : " + mem_pass);
		log("mem_name : " + mem_name);
		log("mem_birth2 : " + mem_birth2);
		log("mem_pnumber : " + mem_pnumber);
		log("mem_email : " + mem_email);
		log("mem_address : " + mem_address);
		log("gender : " + gender);
		
		// 입력할 객체 완성
		// 초기 화면과 구분하기 위해서
		/*
		 Members(String mem_id, String mem_pass, String mem_name,
		         String mem_birth2, String mem_pnumber,
			     String mem_email, String mem_address, String gender) 
		*/
		System.out.println("### 입력 처리 proc##"+mem_name);
		if(!mem_name.equals("")){
			
			System.out.println("### 입력 처리 proc##");
			Members1 ins = new Members1(mem_id, mem_pass, mem_name, mem_birth2,
					                  mem_pnumber, mem_email, mem_address, gender);
					
		    log("입력 내용 확인 : " + ins.getMem_name());
					
		    A00_Dao dao = new A00_Dao();
		    dao.insertMem(ins);
		    
		    System.out.println("### 입력 처리 완료##");
	    }
		
		// 2. 모델 처리
		
		// 3. view 호출
		// http://localhost:7080/sistProject3/memInsert.do
		String page = "miniHome\\join_member02.jsp";
				
		RequestDispatcher rd = request.getRequestDispatcher(page);
				
		rd.forward(request, response);
	}

}
