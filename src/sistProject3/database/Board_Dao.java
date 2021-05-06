package sistProject3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sistProject3.page.BPiclistPageObject;
import sistProject3.page.BlistPageObject;
import sistProject3.vo.Board;
import sistProject3.vo.Comments;

public class Board_Dao {
	// 1. �곗�댄�곕��댁�� �곌껐 泥�由�
	private Connection con;
	// 2. ����
	private Statement stmt;
	private PreparedStatement pstmt;
	
	// 3. 寃곌낵媛� 諛��� 媛�泥�
	private ResultSet rs;
	
	// #�곌껐 泥�由� 湲곕�� 硫�����.(怨듯�� 硫�����-�곌껐)
	public void setCon() throws SQLException {
		// 1. driver 硫�紐⑤━ 濡���.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. �뱀�� ��踰�.
		//	- ���� ��蹂� : ���쇱�대�紐�:@ip:port:sid
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		// ���쇱�대� 留ㅻ���� 媛�泥대�� �듯�댁�� Connection 媛�泥대�� ����
			con = DriverManager.getConnection(info, "SNS", "1111");
			System.out.println("���� �깃났 !!! ^^ ����");
	}
	
	// 寃���湲� 紐⑸� 議고��(boards + members議곗�명���대� VO�ъ��)
	// Boards VO�� ���대� 蹂��� ���� ������ ���쇳��寃� ����
//	public ArrayList<Boards> boardsList(){ // ��蹂�
	// ���댁� 泥�由щ�� ���� 媛�泥� ���� 諛�湲�
	public ArrayList<Board> boardList(BlistPageObject blpageObject){
		ArrayList<Board> blist = new ArrayList<Board>();
		try {
			setCon();
			String sql = " select * \r\n"
					+ "FROM (select rownum num, BOARD_TITLE, BOARD_DATE, BOARD_NO \r\n"
					+ "FROM (select * from BOARD b, MEMBERS m\r\n"
					+ "WHERE b.MEM_ID = m.MEM_ID AND m.MEM_ID = ? \r\n"
					+ "AND board_picture IS NULL\r\n"
					+ "order by BOARD_NO desc)) \r\n"
					+ "where num between ? and ? ";
			System.out.println("議고��由ъ�ㅽ��");
			System.out.println(sql); // 異��� 媛��쇰� ���� sql�� 臾몄�� ����吏� ����
			// �ㅽ��媛�泥�, �곗�댄�� ����
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, blpageObject.getAccepter());
            pstmt.setInt(2, blpageObject.getStartRow());
            pstmt.setInt(3, blpageObject.getEndRow());

			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 	public Boards(String board_title, Date board_date)
				blist.add(new Board(rs.getInt("board_no"), rs.getString("board_title"), rs.getDate("board_date")));
			}
			System.out.println(sql);
			System.out.println("�곗�댄�� �ш린: " + blist.size());
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
		return blist;
	}
	
	// 寃���湲� 珥� ��肄��� �� 援ы���� 濡�吏�(���댁�) 
	public int getTotalRow (BlistPageObject blpageObject) {
		int total = 0;
		try {
			setCon();

			String sql = " SELECT count(*) \r\n"
					+ "FROM BOARD\r\n"
					+ "WHERE MEM_ID = ? \r\n"
					+ "AND board_picture IS NULL " ;
			System.out.println("議고��由ъ�ㅽ��");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, blpageObject.getAccepter());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##DB 愿��� ����##");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("##湲고�� ����##");
			System.out.println(e.getMessage());
		}
		
		return total;
	}

	// boards ���� 寃���湲� 議고��
	public Board getBoardCD(int board_no) {
		//updateHit(board_no);
		Board board = null;
		try {
			setCon();
			String sql = " SELECT B.BOARD_TITLE, B.BOARD_LIKE, \r\n"
					+ "B.BOARD_CONTENT,B.BOARD_DATE, M.MEM_NAME, B.board_picture\r\n"
					+ "FROM MEMBERS M , BOARD B\r\n"
					+ "WHERE B.MEM_ID=M.MEM_ID \r\n"
					+ "AND B.BOARD_NO =? " ;

			pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board(rs.getString("board_title"), rs.getInt("board_like"), rs.getString("board_content"),
						rs.getDate("board_date"), rs.getString("mem_name"), rs.getString("board_picture"));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##DB 愿��� ����##");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("##湲고�� ����##");
			System.out.println(e.getMessage());
		}
		
		return board;
	}

	
	// INSERT INTO BOARD VALUES(BOARD_NO_SEQ.NEXTVAL,'HIMAN','�������몄��17',3,'�ㅻ���� �⑤じ�� �������대��11',SYSDATE, null);
	// (int board_no, String board_title, int board_like, String board_content, Date board_date,
	// String board_picture, String mem_name)
	// 寃���湲� �깅�(Boards VO�ъ��)
	public void insertBoard(Board ins) {
		// 1. ���� autocommit(false)
		try {
			// 1. �곌껐
			setCon();
			// 2. ����
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = " INSERT INTO BOARD VALUES(BOARD_NO_SEQ.NEXTVAL, ?, \r\n"
					+ "			?, ?, ?, \r\n"
					+ "			sysdate, ?) ";
			System.out.println("###");
			System.out.println(sql); // 異��� 媛��쇰� ���� sql�� 臾몄�� ����吏� ����
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ins.getMem_id());
            pstmt.setString(2, ins.getBoard_title());
            pstmt.setInt(3, ins.getBoard_like());
            pstmt.setString(4, ins.getBoard_content());
            pstmt.setString(5, ins.getBoard_picture());
			pstmt.executeUpdate();
			// 3. commit
			con.commit();
			// 4. ���� �댁��
			pstmt.close();
			con.close();
			// 5. ���몄�由�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("db 泥�由� ����");
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쇰�����");
			System.out.println(e.getMessage());
		}
	}

	// �ъ� 寃���臾� ���댁� 泥�由щ�� ���� 媛�泥� ���� 諛�湲�
	public ArrayList<Board> bPicList(BPiclistPageObject bplPageObject){
		ArrayList<Board> bplist = new ArrayList<Board>();
		try {
			setCon();
			String sql = " select * \r\n"
					+ "FROM (select rownum num, BOARD_NO, board_picture\r\n"
					+ "FROM (select * from BOARD b, MEMBERS m\r\n"
					+ "WHERE b.MEM_ID = m.MEM_ID AND m.MEM_ID = ? \r\n"
					+ "AND board_picture IS NOT NULL\r\n"
					+ "order by BOARD_NO desc)) \r\n"
					+ "where num between ? and ? ";
			System.out.println("議고��由ъ�ㅽ��");
			System.out.println(sql); // 異��� 媛��쇰� ���� sql�� 臾몄�� ����吏� ����
			// �ㅽ��媛�泥�, �곗�댄�� ����
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bplPageObject.getAccepter());
			pstmt.setInt(2, bplPageObject.getStartRow());
			pstmt.setInt(3, bplPageObject.getEndRow());

			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 	public Boards(String board_title, Date board_date)
				bplist.add(new Board(rs.getInt("board_no"), rs.getString("board_picture")));
			}
			System.out.println(sql);
			System.out.println("�곗�댄�� �ш린: " + bplist.size());
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
		return bplist;
	}

	// �ъ� 寃���湲� 珥� ��肄��� �� 援ы���� 濡�吏�(���댁�) 
	public int getPtotalRow (BPiclistPageObject bplPageObject) {
		int ptotal = 0;
		try {
			setCon();
	
			String sql = " SELECT count(*) \r\n"
					+ "FROM BOARD\r\n"
					+ "WHERE MEM_ID = ? \r\n"
					+ "AND board_picture IS NOT NULL " ;
			System.out.println("議고��由ъ�ㅽ��");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bplPageObject.getAccepter());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ptotal = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##DB 愿��� ����##");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("##湲고�� ����##");
			System.out.println(e.getMessage());
		}
		
		return ptotal;
	}
	
	// 寃���湲� ��湲� 議고��
	public ArrayList<Comments> bcomList(int board_no){
		ArrayList<Comments> bclist = new ArrayList<Comments>();
		try {
			setCon();
			String sql = " SELECT COM_CONTENT, COM_DATE, m.MEM_NAME \r\n"
					+ "FROM COMMENTS c, MEMBERS m\r\n"
					+ "WHERE c.MEM_ID = m.MEM_ID AND BOARD_NO = ? \r\n"
					+ "ORDER BY COM_DATE ";
			System.out.println("comlist議고��");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				/*
				 * (String com_content, Date com_date, String mem_name)
				 */
		        bclist.add(new Comments(rs.getString(1),
		                 rs.getDate(2),rs.getString(3)));
		    }
			System.out.println(sql);
			System.out.println("�곗�댄�� �ш린: " + bclist.size());
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
		return bclist;
	}
	
	// ��湲� �깅�
	public void insertComments(Comments comm){

		try {
			setCon();
			con.setAutoCommit(false);

			String sql=" INSERT INTO COMMENTS(COM_NO, BOARD_NO, MEM_ID, COM_CONTENT, COM_DATE) \r\n"
					+ "values(COM_NO_SEQ.NEXTVAL, ?, ?, ?,sysdate) ";

			System.out.println("###");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comm.getBoard_no());
			pstmt.setString(2, comm.getMem_id());
			pstmt.setString(3, comm.getCom_content());
			pstmt.executeUpdate();
			con.commit(); // ����
			pstmt.close();
			con.close();
			// 3. commit
			// 4. ���몄�由�
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
	
	public int pictureList(String mem_id) {
		int total = 0;
		try {
			setCon();

			String sql = " SELECT  COUNT(BOARD_NO)\r\n" + 
					"FROM  BOARD B ,MEMBERS M WHERE board_picture IS NOT NULL\r\n" + 
					"AND M.MEM_ID=B.MEM_ID AND b.MEM_ID =?" ;
			System.out.println("�ъ� 媛���");
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##DB 愿��� ����##");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("##湲고�� ����##");
			System.out.println(e.getMessage());
		}
		
		return total;
	}
	
	//諛⑸�濡� 
		public int gbookList(String mem_id) {
			int total = 0;
			try {
				setCon();

				String sql = " SELECT count(gbook_no) FROM GUESTBOOK g ,members m WHERE \r\n" + 
						"g.MEM_ID =m.MEM_ID AND g.MEM_ID =?" ;
				System.out.println("諛⑸�濡� 媛���");
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					total = rs.getInt(1);
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("##DB 愿��� ����##");
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("##湲고�� ����##");
				System.out.println(e.getMessage());
			}
			
			return total;
		}
	/*
	 SELECT B.BOARD_TITLE, B.BOARD_LIKE,
	B.BOARD_CONTENT,B.BOARD_DATE, M.MEM_NAME
	FROM MEMBERS M , BOARD B
	WHERE B.MEM_ID=M.MEM_ID 
	AND B.BOARD_NO =? 
	 */

	public int boardCnt(String mem_id) {
		//updateHit(board_no);
		int total1 = 0;
		try {
			setCon();
			String sql = "SELECT count(board_no) FROM board WHERE board_picture IS NULL\r\n" + 
					"AND MEM_ID =?" ;

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				total1 = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##DB 愿��� ����##");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("##湲고�� ����##");
			System.out.println(e.getMessage());
		}
		
		return total1;
	}
	
	public int follwingCnt(String mem_id) {
		//updateHit(board_no);
		int total=0;
		try {
			setCon();
			String sql = "SELECT count(*) FROM FOLLOW f \r\n" + 
					"WHERE MEM_ID ='"+mem_id+"'" ;
			stmt=con.createStatement();
			//pstmt = con.prepareStatement(sql);
			rs=stmt.executeQuery(sql);
			System.out.println(total);
		while(rs.next()) {
			total= rs.getInt(1);
			System.out.println(total);
		}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("##DB 愿��� ����##");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("##湲고�� ����##");
			System.out.println(e.getMessage());
		}
		
	return total;
	}
	
	
	public int follwerCnt(String mem_id) {
		//updateHit(board_no);
				int total=0;
				try {
					setCon();
					String sql = "SELECT count(*) FROM FOLLOW F,MEMBERS M\r\n" + 
							"WHERE F.FOLLOWING_ID ='"+mem_id+"' AND M.MEM_ID =F.MEM_ID";
					stmt=con.createStatement();
					//pstmt = con.prepareStatement(sql);
					rs=stmt.executeQuery(sql);
					System.out.println(total);
				while(rs.next()) {
					total= rs.getInt(1);
					System.out.println(total);
				}
					
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("##DB 愿��� ����##");
					System.out.println(e.getMessage());
				} catch(Exception e) {
					System.out.println("##湲고�� ����##");
					System.out.println(e.getMessage());
				}
				
			return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board_Dao dao = new Board_Dao();
		// 寃���湲� 紐⑸� 議고��
//		ArrayList<Board> blist = dao.boardList("HIGIRL", pageObject);
//		System.out.println("�ш린: " + blist.size());
		// DAO �대���ㅼ�� 寃����댁�� �쇱����� ��肄����� ��瑜� 援ы���� 濡�吏��� 異�媛�����.
//		ArrayList<Boards> fblist = dao.boardsfList(1112, 1, 5, "mem_name", "愿�由ъ��");
//		System.out.println("�ш린: " + fblist.size());
 		// ���� 寃���湲� 議고�� 
//		Board board = dao.getBoardCD(6);
//				System.out.println("�ш린: " + board);
		//int bcount = dao.getCount(1112);
		//System.out.println("�ш린: " + bcount);
		// �곗�댄�� �깅� 
//		Board ins = new Board(0, "HIMAN", "�깅�0316", 0, "testtest0316", null, "");
//		dao.insertBoard(ins);
		// 寃���湲� ��湲� �깅�
		Comments comm = new Comments(0, 81, "DOOBOO","81踰� 寃���湲� ��湲� insert ���ㅽ�몄�2", null);
		dao.insertComments(comm);		
		
		// 議고���� 利�媛�
		//dao.updateHit(2);
		//		try {
//			dao.setCon();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
