/*
 * �� ��ü�� JTable�� �����ڿ��� �䱸�ϴ� ��Ʈ�ѷ� ��ü�̴�.
 * �� ��ü�� ������ �����ΰ� ������ �и������ִ� �߰��� �����̴�.
 */
package model;

import java.sql.Connection;

import javax.swing.table.AbstractTableModel;

public class MariaModel extends AbstractTableModel{
	String driver="oracle.jdbc.driver.OracleDriver.class";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data=new String [3][3];
	public MariaModel() {
		data[0][0]="û����";
		data[0][1]="�����ٳ�";
		data[0][2]="2000";
		data[1][0]="�����";
		data[1][1]="���";
		data[1][2]="5000";
		data[2][0]="ġ��";
		data[2][1]="����Ű";
		data[2][2]="20000";
		
		
	}
	
	Connection con;
	
	public int getRowCount() {//�÷��� ������ ��ȯ�ϴ� �޼���
		return data.length;
	}

	
	public int getColumnCount() {//���ڵ��� ������ ��ȯ�ϴ� �޼���
		return data[0].length;
	}

	
	public Object getValueAt(int row, int col) {//Ư����ġ�� ���� ��ȯ�ϴ� �޼���		
		return data[row][col];
	}

}
