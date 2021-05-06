package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Background;

public class Background_Dao {

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
	   
	   public ArrayList<Background> bgList(Background sch){
		   ArrayList<Background> blist = new ArrayList<Background>();
		   
		   try {
			setCon();
			String sql = "SELECT * FROM BG";
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
			    
		   return blist;
	   }
	   
	   
	   
	   public void insertBG(Background ins) {
		   try {
			setCon();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = "INSERT INTO BG VALUES(BG_NO_SEQ.NEXTVAL,'"+ins.getBG_NAME()+"','"+ins.getBG_URL()+"')";
			stmt.executeUpdate(sql);
			System.out.println(sql);
			con.commit();
			stmt.close();
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
