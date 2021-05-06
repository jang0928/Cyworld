
package sistProject3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import sistProject3.vo.Members1;


public class A00_Dao {

	// DAO : Database Access Object
	// 1. �곗�댄�곕��댁�� �곌껐 泥�由�
	private Connection con;
	// 2. ����
	private Statement stmt;
	private PreparedStatement pstmt;
	// 3. 寃곌낵媛� 諛��� 媛�泥�
	private ResultSet rs;

	// # �곌껐 泥�由� 湲곕�λ�����(怨듯�� 硫����� - �곌껐)
	public void setCon() throws SQLException {
		// 1. driver 硫�紐⑤━ 濡���
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. �뱀�� ��踰�
		//  - ���� ��蹂� : ���쇱�대�紐�:@ip:port:sid
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
	
		    // ���쇱�대� 留ㅻ���� 媛�泥대�� �듯�댁�� Connection 媛�泥대�� ����
			con = DriverManager.getConnection(info, "SNS", "1111");
			
			System.out.println("���� �깃났!");		
			// TODO Auto-generated catch block
		
	}

	// �깅� ( ����媛���)
	public void insertMem(Members1 ins) {
		// 1. ���� 
		try {
			setCon();
			con.setAutoCommit(false);
			
			// 2. ����
			stmt = con.createStatement();
			String sql = "INSERT INTO MEMBERS\r\n"
					+ "VALUES ('" + ins.getMem_id() + "', '" + ins.getMem_pass() 
					+ "', '" + ins.getMem_name() + "', to_date('" + ins.getMem_birth2() + "', 'YYYY-MM-DD'), '" 
					+ ins.getMem_pnumber() + "',\r\n"
					+ "         '" + ins.getMem_email() + "', '" + ins.getMem_address() + "', sysdate, '" + ins.getGender()+ "', '�쇰�')";
			
			System.out.println("###");
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
			
			// 3. commit
			con.commit();
			
			// 4. ���� �댁��
			stmt.close();
			con.close();
			
			// 5. ���� 泥�由�	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("# DB ���� 泥�由� #");
			System.out.println(e.getMessage());
			try {
				con.rollback();
				
				System.out.println("���� 諛����쇰� ��蹂� 泥�由�");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				System.out.println("rollback�� 臾몄�� 諛���");
			}
		} catch (Exception e) {
			System.out.println("# �쇰� ���� 泥�由� #");
			System.out.println(e.getMessage());
		}
	
	}

	
	
	// ���대�� 議고�� 泥�由� 硫�����
		public ArrayList<Members1> memList(String mem_pnumber){
			ArrayList<Members1> mlist = new ArrayList<Members1>();
			// 1. 怨듯�� �곌껐 硫����� �몄�
			try {
				setCon();
				
		        // 2. Statement 媛�泥� ���� (�곌껐 媛�泥� - Connection)
				String sql = "SELECT mem_id\r\n"
						+ "FROM MEMBERS\r\n"
						+ "WHERE MEM_PNUMBER = ? ";// ;�� 諛���
				System.out.println("議고��");
				System.out.println(sql);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_pnumber);
				
				// 3. ResultSet 媛�泥� ���� (���� 媛�泥� - Statement)
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					mlist.add(new Members1(rs.getString("mem_id"), sql));
				}
				
				System.out.println(sql);
				System.out.println("�곗�댄�� �ш린 : " + mlist.size());
				
				
				// 4. ������ �댁��
				rs.close();
				pstmt.close();
				con.close();
				
				// 5. ���� 泥�由�		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("# DB 愿��� ���� #");
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("# 湲고�� ���� #");
				System.out.println(e.getMessage());
			}
				
			return mlist;
		}

	// 鍮�諛�踰��� ����
		public void updatePass(Members1 upt) {
			// 1. ���� 
			try {
				setCon();
				con.setAutoCommit(false);
				
				// 2. ����
				String sql = "UPDATE MEMBERS\r\n"
						+ "SET mem_pass = ?\r\n"
						+ "WHERE MEM_PNUMBER = ?\r\n"
						+ "AND mem_id = ?";
				
				System.out.println("����");
				System.out.println(sql);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, upt.getMem_pass());
				pstmt.setString(2, upt.getMem_pnumber());
				pstmt.setString(3, upt.getMem_id());
				
				pstmt.executeUpdate();
				
				// 3. commit
				con.commit();
				
				// 4. ���� �댁��
				pstmt.close();
				con.close();
				
				// 5. ���� 泥�由�	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("# DB ���� 泥�由� #");
				System.out.println(e.getMessage());
				try {
					con.rollback();
					
					System.out.println("���� 諛����쇰� ��蹂� 泥�由�");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					System.out.println("rollback�� 臾몄�� 諛���");
				}
			} catch (Exception e) {
				System.out.println("# �쇰� ���� 泥�由� #");
				System.out.println(e.getMessage());
			}
		
		}

	public Members1 login(Members1 login) {
			Members1 mem = null;
			try {
				setCon();
				
				String sql = "SELECT *\r\n"
						+ "FROM members\r\n"
						+ "WHERE mem_id = ?\r\n"
						+ "AND mem_pass = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, login.getMem_id());
				pstmt.setString(2, login.getMem_pass());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					/*
					 	private String mem_id;
						private String mem_pass;
						private String mem_name;
						private Date mem_birth;
						private String mem_birth2;   // ���� ����
						private String mem_pnumber;
						private String mem_email;
						private String mem_address;
						private Date mem_sign_up;
						private String gender;
						private String mem_auth; 
					*/
					mem = new Members1(rs.getString("mem_id"),
							       rs.getString("mem_pass"),
							       rs.getString("mem_name"),
							       rs.getDate("mem_birth"),
							       rs.getString("mem_pnumber"),
							       rs.getString("mem_email"),
							       rs.getString("mem_address"),
							       rs.getDate("mem_sign_up"),
							       rs.getString("gender"),
							       rs.getString("mem_auth")
							      );
				}
				
				// ���� �댁��
				rs.close();
				pstmt.close();
				con.close();
				
				// ���� 泥�由�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("# DB 愿��� ���� #");
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("# 湲고�� ���� #");
				System.out.println(e.getMessage());
			}
			
			return mem;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		A00_Dao dao = new A00_Dao();

		Members1 ins = new Members1("heehee", "11223344", "�щ��", "1988-08-05", "01056785678", 
							                  "hee@naver.com", "���� 媛���援�", "��");
		dao.insertMem(ins);

		
//		ArrayList<Members1> mlist = dao.memList("010-1234-5678");
//		
//		Members1 mem = dao.login(new Members1("MASTER","1111"));
//		System.out.println(mem.getMem_id());
		
	}

}
