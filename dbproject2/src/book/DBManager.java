/*
 * 1.�����ͺ��̽� ���Ӱ��� ������ �������� ���� �ʱ� ����
 * 
 * 2.�̱������� ���������ν�, �ν��Ͻ��� ���ʿ��ϰ� ���� ������ �ʾƵ� ��
 * 
 * 3.�̱��� ���� Connection �ɹ��� �����ϰ� �����Ƿ�, 
 * Connection�� �ѹ��� ������ �� �ִ�..
 */
package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	static private DBManager instance;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;
	
	private DBManager(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("�帮�ƹ��ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public DBManager getInstance() {
		if(instance==null){
			instance=new DBManager();
		}
		return instance;
	}
	public Connection getConnection(){
		return con;
	}
	public void disConnect(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
