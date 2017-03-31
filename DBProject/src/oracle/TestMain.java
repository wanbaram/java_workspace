/*
 * �츮�� ������� �����ͺ��̽� ��ǰ��
 * ��� DBMS!!!
 * DB(�����) MS(�����ý���) -��Ʈ��ũ ����̶� 
 * ���������� �����ϴ�!!! 
 * 
 * ���� ������� ��Ʈ��ũ �������� TCP/IP
 * ����̹Ƿ�, �������� ȣ��Ʈ�� �����Ϸ��� 
 * �� ȣ��Ʈ�� �ּҸ� �˾ƾ� �ϴµ�, ����� 
 * TCP/IP������ IP�ּҸ� �˾ƾ� �Ѵ�
 */
package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) {
		// 1�ܰ�- ����Ŭ�� �ڹٰ� ������ �� �ִ�
		//�ڵ尡 ����ִ� jar������ �޸𸮿� �ε��ؾ� �Ѵ�..
		//�̷� �����ͺ��̽� ���� jar������ �ڹٿ����� ����̹��� �Ѵ�.
		//����̹��� db �����翡�� �����Ѵ�..
		//oracle-->����Ŭ��
		//mysql-->����Ŭ��
		//mssql-->MS
		//2�ܰ� ����Ŭ�� ��������!!
		//����̹� Ŭ���� �ε�!!
		//�����Ѱ� ��Ʈ�������� ������ ��
		//�ɹ� ������ �ƴ϶� ��������
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","batman","1234");
			if(con!=null){
				//System.out.println("���� ����");
				//���� ������ ������ ���̺� insert
				String sql="insert into company(company_id,brand) values(seq_company.nextval,'����Ű')";
				//������ ������ ���ؼ��� �������� �����ϴ� 
				//��ü�� �̿��ؾ� �ϴµ�, �� ��ü�� �ٷ�
				//PreparedStatement �������̽� �̴�!!
				pstmt=con.prepareStatement(sql);
				int result=pstmt.executeUpdate();//������ ���� �޼���
				//�� ������ ���࿡ ���� �ݿ��� ���ڵ��� ���� ��ȯ���ش�!!
				if(result==1){
					System.out.println("�Է¼���");
				}else{
					System.out.println("�Է½���");
				}
			}else{
				System.out.println("���� ����");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//��Ʈ���� DB�����۾� �Ŀ� �ݵ�� 
			//�ݴ� ó���� �ؾ��Ѵ�!!
			try {
				if(pstmt!=null){
				pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					if(con!=null){
					con.close();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
	}
	
}
