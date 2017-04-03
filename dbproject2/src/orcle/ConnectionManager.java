/*
 * 각 TableModel마다 접속 정보와 접속객체를 두개되면,
 * 접속정보가 바뀔때 모든 클래스의 코드도 수정해야 하는
 * 유지보수상의 문제 뿐만 아니라, 각 TableModel마다 Connection을
 * 생성하기 때문에 접속이 여러개 발생한다.
 * 하나의 어플리케이션이 오라클과 맺는 접속은 1개만으로 충분하다. 그리고
 * 접속이 여러개임ㄴ 하나의 세션에서 발생시키는 가종 DML작업이 통이되지 못하게 된다.
 * 즉 다른 사람으로 인식됨...
 * 객체의 인스턴스를 메모리 힙에 1개면 
 *
 */
package orcle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static private ConnectionManager instance;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;
	//개발자가 제공하는 방법 이외의 접근은 아예 
	//차단하자!! 사용자에 의한 임의 생성을 막자
	//즉 new 막자!!
	private ConnectionManager(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("드리아버로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//인스턴스의 생성없이도, 외부에서 메서드를 호출하여 이 객체의 인스턴스를 가져갈 수 있도록
	//getter를 제공해준다!!
	static public ConnectionManager getInstance(){
		if(instance==null){
			instance=new ConnectionManager();
		}
		return instance;
	}
	//이 메서드를 호출자는 Connection 객체를 반환받게 된다..
	public Connection getConnection(){
		return con;
	}
	public void disConnect(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
