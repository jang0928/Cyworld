package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Members_Dao;
import vo.Members;

/**
 * Servlet implementation class memController
 */
@WebServlet(name = "member.do", urlPatterns = { "/member.do" })
public class memController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 요청
		//	1) 한글에 대한 encoding
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println("##이름 : " + name);
		System.out.println("##아이디 : " + id);
		//2. 모델
		//service 시작
		if(name==null) name="";
		if(id==null) id="";
		
		//DB 접속 메서드를 통해 모델 데이터 처리
		//------dao 단계 시작
		Members_Dao dao = new Members_Dao();
		//------dao 단계 끝
		ArrayList<Members> List = dao.memList(name, id);
		//======service 단계 끝======
		//DB에서 온 ArryaList<Members> 데이터를 모델명 memberList로 선언
		//이 모델명 memberList는 view 단에서 el ${memberList}로 활용
		request.setAttribute("memberList", dao.memList(name, id));
		//3. view 처리
		String page = "admin\\members.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}	

}
