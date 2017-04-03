//emp ���̺��� �����͸� ó���ϴ� ��Ʈ�ѷ�!!
package orcle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class DeptModel extends AbstractTableModel{	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String[] column;//�÷��� ���� �迪
	String[][] data;//���ڵ带 ���� �迭
	
	public DeptModel(Connection con) {
		this.con=con;
		
		/*1.����̹� �ε�
		 *2.����
		 *3.������ ����disConnect
		 *4.���Ӵݱ�
		 */
		try {
			if(con!=null){
				String sql="select * from dept";
				//�Ʒ��� pstmt�� ���� �����Ǵ� rs�� Ŀ���� �����ο� �� �ִ�..
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				//��� ���� ��ȯ!!
				rs=pstmt.executeQuery();
				//�÷��� ���غ���!!
				ResultSetMetaData meta=rs.getMetaData();
				int count=meta.getColumnCount();
				
				column= new String[count];
				//�÷����� ä����!1
				for(int i=0; i<column.length; i++){
					//ù��° �÷��� 1�̶�� �����Ѵ�.
					column[i]=meta.getColumnName(i+1);
				}
				rs.last();//���� ���������� ����
				int total=rs.getRow();//���ڵ� ��ȣ
				//�� ���ڵ���� �˾�����, ������ �迭 �����غ���!!
				rs.beforeFirst();
				data= new String[total][column.length];
				//���ڵ带 �������迭�� data�� ä���ֱ�
				for(int i=0; i<data.length; i++){
					rs.next();
					for(int j=0; j<data[i].length; j++){
						data[i][j]=rs.getString(column[j]);
					}
				}
			}
			
		}  catch (SQLException e) {
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
		}
	}

	public int getRowCount() {	
		return data.length;
	}

	public String getColumnName(int index) {
		return column[index];
}

	public int getColumnCount() {
		return column.length;
	}

	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
