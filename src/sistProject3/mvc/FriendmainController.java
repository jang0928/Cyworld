package sistProject3.mvc;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sistProject3.database.FriendList_Dao;
import sistProject3.database.Main_Dao;
import sistProject3.vo.Members1;


/**
 * Servlet implementation class mainController
 */
@WebServlet(name = "friendlist.do", urlPatterns = { "/friendlist.do" })
public class FriendmainController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendmainController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      // # MVC를 통한 EMP 조회 처리.
      // 1. 요청
      //   1) 한글에 대한 encoding
	 	  HttpSession session = request.getSession(true);
	 	  
		 	 Members1 member=  (Members1) session.getAttribute("mem");
      request.setCharacterEncoding("utf-8");
      String mem_id = request.getParameter("mem_id");
      
      String choice = request.getParameter("choice");
      String search = request.getParameter("search");
   
      // 2. 모델
      if(mem_id==null) mem_id="";
      if(choice==null) choice="";
      if(search==null) search="";
      
      FriendList_Dao dao = new FriendList_Dao(); 
         // 팔로잉 리스트 (내가 팔로우 한)
      request.setAttribute("followingList", dao.followingList(member.getMem_id()));
         // 팔로잉 리스트 중 검색
//      ArrayList<Members> List = dao.followingSch(choice, search);   
//      request.setAttribute("followingSch", dao.followingSch(choice, search));
      
         //팔로워 리스트 (나를 팔로우 한)
      request.setAttribute("followerList", dao.followerList(member.getMem_id()));
         //팔로워 리스트 중 검색 
      
         //새 친구 리스트 (전체 회원)
      request.setAttribute("allList", dao.allList(null));
         
      
    //메인 왼쪽
    		Main_Dao dao1 = new Main_Dao();
    		
     
    		
    		request.setAttribute("mainName", dao1.mainName(member.getMem_id()));
    		request.setAttribute("mainProfile", dao1.mainProfile(member.getMem_id()));
      // 3. 화면단 호출--->  ★7080 기준: http://localhost:7080/sistProject3/friendlist.do      

      // http://localhost:7081/sistProject3/friendlist.do      
      String page = "miniHome\\main_friendList.jsp";      
      RequestDispatcher rd = request.getRequestDispatcher(page);
      rd.forward(request, response);
      
            
   }

}