package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Members;

public class Members_Dao {
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
	   
	   
	   //硫ㅻ쾭 議고쉶 DAO
	   public ArrayList<Members> memList(String MEM_NAME, String MEM_ID){
		   ArrayList<Members> list = new ArrayList<Members>();
		   
		   try {
//			1. 怨듯넻 �뿰寃� 硫붿꽌�뱶 �샇異� 
			setCon();
//	        2. Statement 媛앹껜 �깮�꽦(�뿰寃곌컼泥� - Connection)		
			String sql = "SELECT * FROM members\r\n"
					+ "WHERE MEM_NAME LIKE '%'||?||'%'\r\n"
					+ "AND MEM_ID LIKE '%'||?||'%'\r\n"
					+ "ORDER BY MEM_NAME";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, MEM_NAME);
			pstmt.setString(2, MEM_ID);
//			3. ResultSet 媛앹껜 �깮�꽦(���솕媛앹껜 - Statement)
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Members m = new Members(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)
						,rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9),rs.getString(10));
				list.add(m);
			}
			System.out.println("媛앹껜�쓽 媛쒖닔 : " + list.size());
			System.out.println("�몢 踰덉㎏ �뻾�쓽 �씠由� : "+list.get(1).getMEM_NAME());
			System.out.println("泥� 踰덉㎏ �뻾�쓽 �븘�씠�뵒 : "+list.get(0).getMEM_ID());
			
			rs.close();
			pstmt.close();
			con.close();
			
//			5. �삁�쇅 泥섎━
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		   
		   return list;
	   }

	   
	   public void deleteMem(String MEM_ID) {
		   //1. �젒�냽 autocommit(false)
		   try {
			setCon();
			con.setAutoCommit(false);
			//2. ���솕
			
			String sql = "DELETE FROM members WHERE MEM_ID =?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, MEM_ID);
			
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
	   
	   public Members getMembers(String MEM_ID) {
		   Members m = null;
		   
		   try {
			setCon();
			String sql = "SELECT * FROM MEMBERS WHERE MEM_ID=?";

            System.out.println(sql);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, MEM_ID);
            pstmt.executeUpdate();
            rs = pstmt.executeQuery();
            
			while(rs.next()) {
				m=new Members(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)
						,rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9),rs.getString(10));
			}
			System.out.println("�쉶�썝 �씠由� : "+m.getMEM_NAME());
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
		   
		   
		   return m;
	   }
	   
	   
	   
	   public static void main(String[] args) {
		   Members_Dao dao = new Members_Dao();		
		   dao.memList("홍길동","HIMAN");
	}
	   
}
