package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import vo.BoardAndMembers;


public class Board_Dao {
	   // 1. �뜲�씠�꽣踰좎씠�뒪 �뿰寃�
	   private Connection con;
	   // 2. ���솕
	   private Statement stmt;
	   private PreparedStatement pstmt;
	   // 3. 寃곌낵媛� 諛쏅뒗 媛앹껜
	   private ResultSet rs;

	   // # �뿰寃� 泥섎━ 湲곕뒫 硫붿꽌�뱶
	   public void setCon() throws SQLException {
	      // 1. driver 硫붾え由� 濡쒕뵫
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	      // 2. �듅�젙 �꽌踰�
	      // - �젒�냽 �젙蹂�: �뱶�씪�씠踰꾨챸:@ip:port:sid
	      String info = "jdbc:oracle:thin:@localhost:1521:xe";
	      // �뱶�씪�씠踰� 留ㅻ땲�� 媛앹껜瑜� �넻�빐 Connection 媛앹껜瑜� �깮�꽦
	      con = DriverManager.getConnection(info, "SNS", "1111");
	      System.out.println("�젒�냽 �꽦怨�");
	   }
	   
	   
	 //寃뚯떆湲� 議고쉶 DAO
	   	public ArrayList<BoardAndMembers> boardList(String BOARD_CONTENT){
	   		ArrayList<BoardAndMembers> list = new ArrayList<BoardAndMembers>();
	   		
	   		try {
				setCon();
				
				String sql = "SELECT B.BOARD_NO , B.MEM_ID , M.MEM_NAME , B.BOARD_TITLE ,\r\n"
						+ "B.BOARD_CONTENT , B.BOARD_DATE \r\n"
						+ "FROM MEMBERS M, BOARD B \r\n"
						+ "WHERE M.MEM_ID =B.MEM_ID  \r\n"
						+ "AND b.BOARD_CONTENT LIKE '%'||?||'%'\r\n"
						+ "ORDER BY B.BOARD_NO";	
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, BOARD_CONTENT);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BoardAndMembers b = new BoardAndMembers(rs.getInt(1),rs.getString(2),
							rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6));
					list.add(b);
				}
				
				System.out.println("媛앹껜�쓽 媛쒖닔 : " + list.size());
				
				rs.close();
				pstmt.close();
				con.close();
				
//				5. �삁�쇅 泥섎━
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			 
			   return list;
		   }
	   	
	   	public void deleteBoard(int BOARD_NO) {
	   		try {
				setCon();
				con.setAutoCommit(false);
				
				String sql = "DELETE FROM board WHERE BOARD_NO=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, BOARD_NO);
				
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("db 泥섎━ �뿉�윭");
				try {
					con.rollback();
					System.out.println("�뿉�윭 諛쒖깮�쑝濡� �썝蹂�");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("rollback�뿉 臾몄젣 諛쒖깮");
				}
			}catch(Exception e) {
				System.out.println("�씪諛� �뿉�윭");
			}
		   }
	   	
	   	
	   	public BoardAndMembers getBoard(int BOARD_NO) {
	   		BoardAndMembers b = null;
	   			
	   		try {
				setCon();
				String sql = "SELECT B.BOARD_NO , B.MEM_ID , M.MEM_NAME , B.BOARD_TITLE ,B.BOARD_CONTENT , B.BOARD_DATE \r\n"
						+ "FROM MEMBERS M, BOARD B \r\n"
						+ "WHERE M.MEM_ID =B.MEM_ID  \r\n"
						+ "AND B.BOARD_NO = ?";
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, BOARD_NO);
				pstmt.executeUpdate();
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					b = new BoardAndMembers(rs.getInt(1),rs.getString(2),
							rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6));
				}
				
				System.out.println("寃뚯떆湲� 踰덊샇 : "+b.getBOARD_NO());
				System.out.println("寃뚯떆湲� 踰덊샇 : "+b.getBOARD_TITLE());
				System.out.println();
				rs.close();
				pstmt.close();
				con.close();
				
		      } catch (SQLException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			         System.out.println("# DB �삁�쇅 泥섎━ #");
			         System.out.println(e.getMessage());
			      } catch (Exception e) {
			         e.printStackTrace();
			         System.out.println("# 湲고� �삁�쇅 泥섎━ #");
			         System.out.println(e.getMessage());
			      }
	   		
	   		return b;
	   	}
	   
	   public static void main(String[] args) {
		   Board_Dao dao = new Board_Dao();
		   //dao.boardList("");
		   dao.boardList("");
		   
	}
}
