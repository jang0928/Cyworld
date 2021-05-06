package sistProject3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sistProject3.vo.profile;

public class ProfileDao {
	
/*
CREATE TABLE MYHOME(
HOME_NO NUMBER CONSTRAINT PK_MYHOME_HOME_NO PRIMARY KEY,
MEM_ID VARCHAR2(100),
CONSTRAINT FK_MYHOME_MEM_ID FOREIGN KEY (MEM_ID)
REFERENCES MEMBERS(MEM_ID) ON DELETE CASCADE,	
STATUS_MESSAGE VARCHAR2(500),
PROFILE_PHOTO VARCHAR2(1000),
INTORODUCE VARCHAR2(1000),
BG_NO NUMBER,
 CONSTRAINT FK_MYHOME_BG_NO FOREIGN KEY (BG_NO)
REFERENCES BG(BG_NO) ON DELETE CASCADE,
FONT_NO NUMBER,
 CONSTRAINT FK_MYHOME_FONT_NO FOREIGN KEY (FONT_NO)
REFERENCES FONT(FONT_NO) ON DELETE CASCADE,		
TODAY NUMBER,
TOTAL NUMBER,
HOME_CONSTRAINTS VARCHAR2(10) NOT NULL
);
 */
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	//�곌껐 泥�由� 湲곕�� 硫�����
	public void setCon() throws SQLException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info,"SNS","1111");
			System.out.println("�����깃났!!!~!!@@");
	}
	public  ArrayList<profile> proList(String mem_id,int home_no) {
		ArrayList<profile> plist = new ArrayList<profile>();
		try {
			setCon();
			String sql="SELECT MEM_NAME,MEM_PNUMBER,MEM_EMAIL\r\n"
					+ "FROM members M ,MYHOME H\r\n"
					+ "WHERE M.mem_id=? AND H.home_no=?";
			System.out.println("proList議고��");
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, home_no);
			System.out.println(home_no);
			System.out.println(mem_id);
			rs=pstmt.executeQuery();		
			while(rs.next()){
				plist.add(new profile(rs.getString(1), rs.getString(2),rs.getString(3)));
			}
			System.out.println(sql);
			System.out.println("�곗�댄�� �ш린:"+ plist.size());
			rs.close();
			pstmt.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("## db泥�由� ���� ##");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("## �쇰� ���� ##");
			System.out.println(e.getMessage());
		}		
		
		return plist;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProfileDao dao = new ProfileDao();
	}

}
