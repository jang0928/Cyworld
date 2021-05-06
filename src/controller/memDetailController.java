package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Members_Dao;

/**
 * Servlet implementation class memDetailController
 */
@WebServlet(name = "memberDetail.do", urlPatterns = { "/memberDetail.do" })
public class memDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//1. 요청값 처리
		//	1) 기본 조회
		//	# 상세 화면에서 수정/삭제 프로세스를 구분하기 위해 처리
		String proc = request.getParameter("proc"); //가장 중요
		if(proc==null) proc="";
		
		String id = request.getParameter("id");
		//2. 모델처리
		Members_Dao dao = new Members_Dao();
		request.setAttribute("mem", dao.getMembers(id));
		if(proc.equals("del")) {
			System.out.println("삭제 준비 완료 : " + id);
			dao.deleteMem(id);
		}
		
		String page="admin\\members_detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}