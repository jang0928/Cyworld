package sistProject3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sistProject3.vo.Bcomments;
import sistProject3.vo.Guestbook;

//database.GuestbookDao
public class GuestbookDao {
	
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
	
	/*
	private int gbook_no;
	private int home_no;
	private String mem_id;
	private String gb_content;
	private Date gb_date;
	private String gb_constraint;
	
	
	SELECT mem_id,gb_date,gb_content
	FROM guestbook
	WHERE gbook_no =1
	
	INSERT INTO GUESTBOOK select
	GUESTBOOK_NO_SEQ.NEXTVAL,h.home_no,m.mem_id,'�ㅻ��留��� �ㅻ�몄��~',
	 sysdate,'Y' 
	 FROM MYHOME h, members m
	 WHERE h.HOME_NO =1

	 */
	public ArrayList<Guestbook> bookList(int home_no){
		ArrayList<Guestbook> blist = new ArrayList<Guestbook>();
		try {
			setCon();
			String sql="SELECT gbook_no,mem_id,gb_date,gb_content,home_no\r\n"
					+ "						FROM guestbook\r\n"
					+ "						WHERE home_no =?\r\n"
					+ "					 ORDER BY GBOOK_NO DESC";
			System.out.println("bookList議고��");
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, home_no);
			System.out.println(home_no);
			rs=pstmt.executeQuery();		
			while(rs.next()){
				blist.add(new Guestbook(rs.getInt(1) ,rs.getString(2),rs.getDate(3),
						rs.getString(4),rs.getInt(5)));
			}
			System.out.println(sql);
			System.out.println("�곗�댄�� �ш린:"+ blist.size());
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
		return blist;
	}
	
	/*
INSERT INTO GUESTBOOK 
select
GUESTBOOK_NO_SEQ.NEXTVAL,
h.home_no,
m.mem_id,
 '�ㅻ��留��� �ㅻ�몄��~',
 sysdate,
 'Y' 
 FROM MYHOME h, members m
 WHERE h.HOME_NO =1 AND m.MEM_ID ='HIMAN'
 

 INSERT INTO GUESTBOOK 
select
GUESTBOOK_NO_SEQ.NEXTVAL,?,?,?,sysdate,? 
 FROM MYHOME h, members m
 WHERE h.HOME_NO =1 AND m.MEM_ID ='HIMAN'
 
 INSERT INTO GUESTBOOK values(
GUESTBOOK_NO_SEQ.NEXTVAL,?,?,?,sysdate,? 
 FROM MYHOME h, members m
 WHERE h.HOME_NO =? AND m.MEM_ID =?)
 
 
 	private int gbook_no;
private int home_no;
private String mem_id;
private String gb_content;
private Date gb_date;
private String gb_constraint;

			pstmt.setInt(1, bins.getGbook_no());
		pstmt.setInt(2, bins.getHome_no());
		pstmt.setString(3, bins.getMem_id());
		pstmt.setString(4, bins.getGb_content());
		pstmt.setDate(5,(Date)(bins.getGb_date()));
		pstmt.setString(6, bins.getGb_constraint());
		
		
					pstmt.setInt(1, bins.getHome_no());
		pstmt.setString(2, bins.getMem_id());
		pstmt.setString(3, bins.getGb_content());
		pstmt.setString(4, bins.getGb_constraint());
		
		
		INSERT INTO GUESTBOOK values(\r\n"
					+ "	GUESTBOOK_NO_SEQ.NEXTVAL,?,?,?,sysdate,?)
		
		SELECT gbook_no,mem_id,gb_date,gb_content,home_no
						FROM guestbook
						WHERE home_no =1
					 ORDER BY GBOOK_NO DESC
	 */	
	public void insertGuestbook(Guestbook bins) {
		try {
			setCon();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql="INSERT INTO GUESTBOOK values(\r\n"
					+ "	GUESTBOOK_NO_SEQ.NEXTVAL,?,?,?,sysdate,?)";
			System.out.println("####");
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bins.getHome_no());	
			pstmt.setString(2, bins.getMem_id());
			pstmt.setString(3, bins.getGb_content());
			pstmt.setString(4, bins.getGb_constraint());
			
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		}catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         System.out.println("db 泥�由� ����");
	         System.out.println(e.getMessage());
	         try {
	            con.rollback();
	            System.out.println("���� 諛����쇰� ��蹂� 泥�由�");
	            System.out.println(e.getMessage());
	         } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	            System.out.println("rollback�� 臾몄��諛���");
	            System.out.println(e.getMessage());
	         }
	      } catch (Exception e) {
	         System.out.println("�쇰� ����");
	         System.out.println(e.getMessage());
	      }
	}	
	// 諛⑸�濡� ��湲� 議고��
	public ArrayList<Bcomments> bcomList(int gbook_no){
		ArrayList<Bcomments> gbclist = new ArrayList<Bcomments>();
		try {
			setCon();
			String sql = "SELECT COM_CONTENT, COM_DATE, m.MEM_NAME \r\n"
					+ "FROM COMMENTS c, MEMBERS m\r\n"
					+ "WHERE c.MEM_ID = m.MEM_ID AND GBOOK_NO = ?\r\n"
					+ "ORDER BY COM_DATE";
			System.out.println("comlist議고��");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,gbook_no);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				/*
				 * (String com_content, Date com_date, String mem_name)
				 */
				gbclist.add(new Bcomments(rs.getString(1),
		                 rs.getDate(2),rs.getString(3)));
		    }
			System.out.println(sql);
			System.out.println("�곗�댄�� �ш린: " + gbclist.size());
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("## db泥�由� ���� ##");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("## �쇰� ���� ##");
			System.out.println(e.getMessage());
		}
		return gbclist;
	}

	// ��湲� �깅�
	/*
	 INSERT INTO COMMENTS (COM_NO,GBOOK_NO, MEM_ID, COM_CONTENT, COM_DATE)
		valueS(COM_NO_SEQ.NEXTVAL,1,'HIMAN','��湲��ш린~!',SYSDATE);
		
	 INSERT INTO COMMENTS (COM_NO,GBOOK_NO, MEM_ID, COM_CONTENT, COM_DATE)
		valueS(COM_NO_SEQ.NEXTVAL,?,?,?,SYSDATE);	
		
	 */
	public void insertGbComments(Bcomments comm){
	
		try {
			setCon();
			con.setAutoCommit(false);

			String sql="	 INSERT INTO COMMENTS (COM_NO,GBOOK_NO, MEM_ID, COM_CONTENT, COM_DATE)\r\n"
					+ "		valueS(COM_NO_SEQ.NEXTVAL,?,?,?,SYSDATE)	 ";
	
			System.out.println("###");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comm.getGbook_no());
			pstmt.setString(2, comm.getMem_id());
			pstmt.setString(3, comm.getCom_content());
			pstmt.executeUpdate();
			con.commit(); 
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("db 泥�由� ����");
			System.out.println(e.getMessage());
			try {
				con.rollback();
				System.out.println("���� 諛����쇰� ��蹂� 泥�由�");
				System.out.println(e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("rollback�� 臾몄��諛���");
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("�쇰� ����");
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {	
		GuestbookDao dao = new GuestbookDao();
		//諛⑸�濡� 議고��
		//ArrayList<Guestbook> blist = dao.bookList(1);
		
		//諛⑸�濡� �깅�
		Guestbook bins = new Guestbook(0,1,"HIMAN","諛⑸�濡� insert ��踰�吏� ���ㅽ�몄�",null,"Y");
		dao.insertGuestbook(bins);
	
		//諛⑸�濡� ��湲� �깅� ( ����...��)
		//Bcomments comm = new Bcomments(0, 1, "DOOBOO","1踰� 寃���湲� ��湲� insert ���ㅽ�몄�", null);
		//dao.insertGbComments(comm);	 
		
		//諛⑸�濡� ��湲� 議고��
		 //ArrayList<Bcomments> gbclist = dao.bcomList(1);
		
	}
	
}
