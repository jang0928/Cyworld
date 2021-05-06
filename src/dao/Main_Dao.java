package dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Background;
import vo.Board;
import vo.Font;
import vo.Members;

public class Main_Dao {

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
	   
	   
	   
	   public ArrayList<Members> mList(Member sch){
		   ArrayList<Members> mlist = new ArrayList<Members>();
		   
		   try {
			setCon();
			String sql = "SELECT * FROM MEMBERS";
			System.out.println(sql);
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
            rs = pstmt.executeQuery();
            
			while(rs.next()) {
				Members m=new Members(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)
						,rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9),rs.getString(10));
				mlist.add(m);
			}
			System.out.println("�뜲�씠�꽣�쓽 �겕湲� : " + mlist.size());
			
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
		   System.out.println("�쉶�썝 dao 臾몄젣 �뾾�쓬");
		   return mlist;
	   }
	   
	   
	   
	   public ArrayList<Board> bList(Board sch){
		   ArrayList<Board> boardlist = new ArrayList<Board>();
		   
		   try {
			setCon();
			String sql = "SELECT * FROM Board";
			System.out.println(sql);
			stmt = con.createStatement();
			
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Board b = new Board(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getString(7));
				boardlist.add(b);
			}
			System.out.println("�뜲�씠�꽣�쓽 �겕湲� : "+boardlist.size());
			
			rs.close();
			stmt.close();
			con.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("#db 泥섎━ �삁�쇅#");
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("#�씪諛� �삁�쇅#");
				System.out.println(e.getMessage());		
			}
		   System.out.println("寃뚯떆湲� dao 臾몄젣 �뾾�쓬");    
		   return boardlist;
	   }
	   
	   
	   public ArrayList<Background> bgList(Background sch){
		   ArrayList<Background> blist = new ArrayList<Background>();
		   
		   try {
			setCon();
			String sql = "SELECT * FROM BG";
			System.out.println(sql);
			stmt = con.createStatement();
			
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Background b = new Background(rs.getInt(1),rs.getString(2),rs.getString(3));
				
				blist.add(b);
			}
			System.out.println("�뜲�씠�꽣�쓽 �겕湲� : "+blist.size());
			
			rs.close();
			stmt.close();
			con.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("#db 泥섎━ �삁�쇅#");
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("#�씪諛� �삁�쇅#");
				System.out.println(e.getMessage());		
			}
		   System.out.println("�쉶�썝 dao 臾몄젣 �뾾�쓬");    
		   return blist;
	   }



	public ArrayList<Font> fList(Font sch){
		   ArrayList<Font> flist = new ArrayList<Font>();
		   
		   try {
			setCon();
			String sql = "SELECT * FROM FONT";
			System.out.println(sql);
			stmt = con.createStatement();
			
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Font f = new Font(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
				flist.add(f);
			}
			
			System.out.println("�뜲�씠�꽣�쓽 �겕湲� : " + flist.size());
			
			rs.close();
			stmt.close();
			con.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("#db 泥섎━ �삁�쇅#");
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("#�씪諛� �삁�쇅#");
				System.out.println(e.getMessage());		
			}
		   System.out.println("�룿�듃 dao 臾몄젣 �뾾�쓬");
		   return flist;
	   }
	




	public static void main(String[] args) {
		Main_Dao dao = new Main_Dao();
		
	}
}
