/*
 * �� ��ü�� JTable�� �����ڿ��� �䱸�ϴ� ��Ʈ�ѷ� ��ü�̴�.
 * �� ��ü�� ������ �����ΰ� ������ �и������ִ� �߰��� �����̴�.
 */
package model;

import java.sql.Connection;

import javax.swing.table.AbstractTableModel;

public class OracleModel extends AbstractTableModel{
	String driver="oracle.jdbc.driver.OracleDriver.class";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data=new String [3][2];
	public OracleModel() {
		data[0][0]="¥���";
		data[0][1]="�ϰ����";
		data[1][0]="������ġ";
		data[1][1]="�������";
		data[2][0]="��ũ������ ġŲ";
		data[2][1]="KFC";
		
		
	}
	
	Connection con;
	
	public int getRowCount() {//�÷��� ������ ��ȯ�ϴ� �޼���
		return 3;
	}

	
	public int getColumnCount() {//���ڵ��� ������ ��ȯ�ϴ� �޼���
		return 2;
	}

	
	public Object getValueAt(int row, int col) {//Ư����ġ�� ���� ��ȯ�ϴ� �޼���		
		return data[row][col];
	}

}
