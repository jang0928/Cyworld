package sistProject3.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import sistProject3.vo.Board;
import sistProject3.vo.Members1;


public class FriendList_Dao {

    // 1. �곗�댄�곕��댁�� �곌껐
    private Connection con;
    // 2. ����
    private Statement stmt;
    private PreparedStatement pstmt;
    // 3. 寃곌낵媛� 諛��� 媛�泥�
    private ResultSet rs;

    // # �곌껐 泥�由� 湲곕�� 硫�����
    public void setCon() throws SQLException {
       // 1. driver 硫�紐⑤━ 濡���
       try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       }
       // 2. �뱀�� ��踰�
       // - ���� ��蹂�: ���쇱�대�紐�:@ip:port:sid
       String info = "jdbc:oracle:thin:@localhost:1521:xe";
       // ���쇱�대� 留ㅻ���� 媛�泥대�� �듯�� Connection 媛�泥대�� ����
       // Scott 怨��� ���� 二쇱�� 
       con = DriverManager.getConnection(info, "SNS", "1111");
       System.out.println("���� �깃났");
    }
    
	
	// ��濡��� 紐⑸� - HIMAN�� ��濡��� �� �щ���� 紐⑸� 
	public ArrayList<Members1> followingList(String mem_id){
        ArrayList<Members1> flist=new ArrayList<Members1>();
		try {        
			setCon();
			String sql = " SELECT MEM_NAME, MEM_ID, MEM_EMAIL FROM MEMBERS m WHERE MEM_ID IN (\r\n"
					+ "SELECT FOLLOWING_ID FROM FOLLOW \r\n"
					+ "WHERE MEM_ID = ? ) ";
			System.out.println("# ��濡��� 紐⑸� 議고�� 由ъ�ㅽ��"); // sql 異��� ���� 
			
			System.out.println(sql);  
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, mem_id);
	        rs = pstmt.executeQuery();
			
	        while(rs.next()) {
				// 	public Members(String mem_name, String mem_id, String mem_email)
				flist.add(new Members1(rs.getString(1),
									  rs.getString(2),
									  rs.getString(3)));
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
		return flist;      
	}
    // ��濡��� 由ъ�ㅽ�� 以� 寃��� 
	public ArrayList<Members1> followingSch(String choice, String search ){
        ArrayList<Members1> flist=new ArrayList<Members1>();
		try {        
			setCon();
			String sql = " SELECT MEM_NAME, MEM_ID, MEM_EMAIL FROM MEMBERS m \r\n"
					+ "WHERE \r\n";
			
					if(choice.equals("name")) {
						sql += "MEM_NAME LIKE '%'||'"+search+"'||'%' \r\n";
					}else {
						sql += "MEM_ID LIKE '%'||'"+search+"'||'%' \r\n";
					}
					sql += "AND MEM_ID IN (\r\n"
					+ "SELECT F.FOLLOWING_ID FROM FOLLOW f ,MEMBERS M\r\n"
					+ "WHERE F.MEM_ID =M.MEM_ID AND m.MEM_ID = 'HIMAN')";
			System.out.println("# ��濡��� 紐⑸� 議고�� 由ъ�ㅽ��"); // sql 異��� ���� 
			
			System.out.println(sql);  
	        pstmt = con.prepareStatement(sql);
//	        if(choice.equals("name")) {
//	        	pstmt.setString(1, search);
//	        }else {
//	        	pstmt.setString(1, search);
//	        }
	        
	        //pstmt.setString(2, mem_id);
	        rs = pstmt.executeQuery();
	        while(rs.next()) {
				// 	public Members(String mem_name, String mem_id, String mem_email)
				flist.add(new Members1(rs.getString(1),
									  rs.getString(2),
									  rs.getString(3)));
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
		return flist;      
	}				
		
	
	
	// ��濡��� 紐⑸�
	public ArrayList<Members1> followerList(String mem_id){
        ArrayList<Members1> flist=new ArrayList<Members1>();
		try {        
			setCon();
			String sql = "SELECT MEM_NAME, MEM_ID, MEM_EMAIL FROM MEMBERS m WHERE MEM_ID IN (\r\n"
					+ "SELECT MEM_ID FROM FOLLOW \r\n"
					+ "WHERE FOLLOWING_ID = ? ) ";
			System.out.println("# ��濡��� 紐⑸� 議고�� 由ъ�ㅽ��"); // sql 異��� ���� 
			
			System.out.println(sql);  
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, mem_id);
	        rs = pstmt.executeQuery();
			
	        while(rs.next()) {
				// 	public Members(String mem_name, String mem_id, String mem_email)
				flist.add(new Members1(rs.getString(1),
									  rs.getString(2),
									  rs.getString(3)));
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
		return flist;      
	}	
	
    // ��濡��� 由ъ�ㅽ�� 以� 寃���    
	
	// �� 移�援� - ��泥� ���� 由ъ�ㅽ�� 
	public ArrayList<Members1> allList(Members1 sch){
        ArrayList<Members1> flist=new ArrayList<Members1>();
		try {        
			setCon();
			String sql = "SELECT MEM_NAME, MEM_ID, MEM_EMAIL FROM MEMBERS ";
			System.out.println("# ��泥� ���� 由ъ�ㅽ��"); // sql 異��� ���� 
			
			System.out.println(sql);  
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
			
	        while(rs.next()) {
				// 	public Members(String mem_name, String mem_id, String mem_email)
				flist.add(new Members1(rs.getString(1),
									  rs.getString(2),
									  rs.getString(3)));
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
		return flist;      
	}	
	
        
        
        
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub}
    		
    		FriendList_Dao dao = new FriendList_Dao();
    		//��濡��� 由ъ�ㅽ�� test
    		//ArrayList<Members> flist=  dao.followingList("HIMAN");
    		//��濡��� 由ъ�ㅽ�� 寃��� 泥�由� test
    		//ArrayList<Members> flist=  dao.followingSch("id","master");  
    		ArrayList<Members1> flist=  dao.followingSch("name","源�援���"); 
   		
    	}
    }