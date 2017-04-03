package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;


public class DeptTable extends AbstractTableModel{
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhost:3306/db0401";
	String user="root";
	String password="";
	Connection con;//���� ������ ���� �������̽�
	PreparedStatement pstmt;//���� ���� ��ü
	ResultSet rs;//�������� select���� ��� �������� ������ ���̽���
	int total;//row�� ��
	String[][]data;
	String[] colum = {"deptno","dname","loc"};
	public DeptTable() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con!=null){
				String sql="select *from dept";
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				rs.last();
				total=rs.getRow();
				data=new String[total][colum.length];
				rs.beforeFirst();;
				int index=0;
				while(rs.next()){
					int deptno=rs.getInt("deptno");
					String dname=rs.getString("dname");
					String loc=rs.getString("loc");
					data[index][0]=Integer.toString(deptno);
					data[index][1]=dname;
					data[index][2]=loc;
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
