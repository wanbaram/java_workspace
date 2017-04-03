package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;


public class EmpTable extends AbstractTableModel{
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhost:3306/db0401";
	String user="root";
	String password="";
	Connection con;//접속 정보를 가진 인터페이스
	PreparedStatement pstmt;//쿼리 수행 객체
	ResultSet rs;//쿼리문이 select문일 경우 원격지의 데이터 베이스의
	int total;//row의 수
	String[][]data;
	String[] colum = {"empno","ename","job","mgr","hiredate","sal","comm","deptno"};
	public EmpTable() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con!=null){
				String sql="select *from emp";
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				rs.last();
				total=rs.getRow();
				data=new String[total][colum.length];
				rs.beforeFirst();;
				int index=0;
				while(rs.next()){
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					String job=rs.getString("job");
					String mgr=rs.getString("mgr");
					String hiredate=rs.getString("hiredate");
					int sal=rs.getInt("sal");
					String comm=rs.getString("comm");
					int deptno=rs.getInt("deptno");
					data[index][0]=Integer.toString(empno);
					data[index][1]=ename;
					data[index][2]=job;
					data[index][3]=mgr;
					data[index][4]=hiredate;
					data[index][5]=Integer.toString(sal);
					data[index][6]=comm;
					data[index][7]=Integer.toString(deptno);
					index++;
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}
	@Override
	public int getColumnCount() {
		
		return colum.length;
	}
	@Override
	public int getRowCount() {
		
		return total;
	}
	@Override
	public Object getValueAt(int row, int col) {
		
		return data[row][col];
	}
	

}
