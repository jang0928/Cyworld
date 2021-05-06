package sistProject3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sistProject3.page.BlistPageObject;
import sistProject3.vo.Board;
import sistProject3.vo.Members2;
import sistProject3.vo.Myhome;

public class Main_Dao {
	// 1. 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙 처占쏙옙
	private Connection con;
	// 2. 占쏙옙화
	private Statement stmt;
	private PreparedStatement pstmt;
	
	// 3. 占쏙옙占쏙옙占� 占쌨댐옙 占쏙옙체
	private ResultSet rs;
	
	// #占쏙옙占쏙옙 처占쏙옙 占쏙옙占� 占쌨쇽옙占쏙옙.(占쏙옙占쏙옙 占쌨쇽옙占쏙옙-占쏙옙占쏙옙)
	public void setCon() throws SQLException {
		// 1. driver 占쌨몌옙 占싸듸옙.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 특占쏙옙 占쏙옙占쏙옙.
		//	- 占쏙옙占쏙옙 占쏙옙占쏙옙 : 占쏙옙占쏙옙譴占쏙옙占�:@ip:port:sid
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		// 占쏙옙占쏙옙譴占� 占신댐옙占쏙옙 占쏙옙체占쏙옙 占쏙옙占쌔쇽옙 Connection 占쏙옙체占쏙옙 占쏙옙占쏙옙
			con = DriverManager.getConnection(info, "SNS", "1111");
			System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙 !!! ^^ 占쏙옙占쏙옙");
	}
	
	
	
	
	public Members2 mainName(String mem_id){
		Members2 mem = null;
		try {
			setCon();
			String sql = " SELECT MEM_NAME ,GENDER FROM MEMBERS m \r\n" + 
					"WHERE MEM_ID= ? ";
			System.out.println("占쏙옙회占쏙옙占쏙옙트");
			System.out.println(sql); // 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 sql占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 확占쏙옙
			// 占쏙옙占썅객체, 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mem_id);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 	public Boards(String board_title, Date board_date)
				mem = new Members2(rs.getString("mem_name"),rs.getString("gender"));
			}
			System.out.println(sql);
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("## db처占쏙옙 占쏙옙占쏙옙 ##");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("## 占싹뱄옙 占쏙옙占쏙옙 ##");
			System.out.println(e.getMessage());
		}
		return mem;
	}
	
	public Myhome mainProfile(String mem_id){
		Myhome mem = null;
		try {
			
			setCon();
			String sql = "SELECT home_no,status_message,profile_photo, today,total FROM MYHOME m \r\n" + 
					"WHERE MEM_ID =?";
			System.out.println("占쏙옙회占쏙옙占쏙옙트");
			System.out.println(sql); // 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 sql占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 확占쏙옙
			// 占쏙옙占썅객체, 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mem_id);
//status_message, String profile_photo
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 	public Boards(String board_title, Date board_date)
				mem = new Myhome(rs.getInt("home_no"),
						rs.getString("status_message"),
						rs.getString("profile_photo"),rs.getInt("today"),rs.getInt("total"));
			}
			System.out.println(sql);
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("## db처占쏙옙 占쏙옙占쏙옙 ##");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("## 占싹뱄옙 占쏙옙占쏙옙 ##");
			System.out.println(e.getMessage());
		}
		return mem;
	}
	
	public void updateToday_Hit(String mem_id) {
		try {
			setCon();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = " UPDATE MYHOME SET  total = NVL(total, 0)+1 WHERE mem_id =?";
			System.out.println("###");
			System.out.println(sql); // 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 sql占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 확占쏙옙
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mem_id);
            pstmt.executeUpdate();
			// 3. commit
			con.commit();
			// 4. 占쌘울옙 占쏙옙占쏙옙
			pstmt.close();
			con.close();
			// 5. 占쏙옙占쏙옙처占쏙옙
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("db 처占쏙옙 占쏙옙占쏙옙");
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("占싹반울옙占쏙옙");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_Dao dao = new Main_Dao();
		Members2 mem1;
		System.out.println(dao.mainName("HIMAN").getGender());
		System.out.println(dao.mainProfile("HIMAN").getStatus_message());
		System.out.println(dao.mainProfile("HIMAN").getToday());
		System.out.println(dao.mainProfile("HIMAN").getTotal());
		//dao.updateToday_Hit(1);

		
	}
}
