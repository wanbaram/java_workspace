/*
 * ���ڵ� ����� �迩�� �������� ����
 * ���ڵ��� �� ������ �˼��� ����..
 * 
 */
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//JDBC:Java Data Base Connectivity 
public class ResultSetTest {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;//���ӽõ�X, ������ ���� �װ���� ��� ��ü
	PreparedStatement pstmt;
	ResultSet rs;
	
	//���ڵ� �� ��ü�� �̿��Ͽ� �� ���ڵ� �� 
	//�˾� ���纸��!!
	public ResultSetTest() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con!=null){
				String sql="select *from company";
				//rs�� Ŀ���� ������, �Ĺ��� ������
				//�����Ӱ� �����̰ų� �Ѳ����� �ǳʶٰ�
				//�Ϸ��� ��ũ�� ������ ����ɼ��� �ο��ؾ� �Ѵ�..
				//select���� ��� ������ ������� ���� 
				//���⸸ �Ҳ��� READ_ONLY��, ������ ���ҰŸ�
				//UPDATABLE ����� SELECT���� ���� ���ڵ��
				//�б⸸ �ϱ� �����̴�(READ_ONLY)
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				//Ŀ�� ���� ������ ���ڵ�� ������
				rs.last();
				int num=rs.getRow();//���� �ļ��� ����Ű�� 
				//���ڵ� ��ȣ!! �� ���ڵ��� ��ġ
				System.out.println(num);
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args){
		new ResultSetTest();
		
		
	}

}
