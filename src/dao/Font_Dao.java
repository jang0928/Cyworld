package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Font;

public class Font_Dao {

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
	   
	   
	   
	   public ArrayList<Font> fontList(Font sch){
		   ArrayList<Font> flist = new ArrayList<Font>();
		   
		   try {
			setCon();
			String sql = "SELECT * FROM FONT";
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
		   
		   return flist;
	   }
	   
	   
	   
	   
	   public void insertFont(Font ins) {
		   try {
			setCon();
			con.setAutoCommit(false);
			String sql = "INSERT INTO FONT VALUES(\r\n"
					+ "FONT_NO_SEQ.NEXTVAL,\r\n"
					+ "?,\r\n"
					+ "?,\r\n"
					+ "?\r\n"
					+ ")\r\n"
					+ "";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,ins.FONT_NAME);
			pstmt.setString(2,ins.FONT_URL);
			pstmt.setString(3,ins.FONT_FAMILY);

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
	   
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
