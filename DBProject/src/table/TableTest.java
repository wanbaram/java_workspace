/*
 * ������ ������Ʈ �� �����ͺ��̽��� ��������� �ð�ȭ
 * �ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ� JTable�̴�!!
 */
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame{
	JTable table;
	JScrollPane scroll;
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhost:3306/db0331";
	String user="root";
	String password="";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;//select���� ��츸 �ʿ��� ��?? ����� ��ƾ� �ϹǷ�....
	
	
	String[][] data;
	String[] column={"member_id","name","age"};
	
	public TableTest() {
		//setLayout(new FlowLayout());
		loadData();
		table=new JTable(data,column);
		scroll=new JScrollPane(table);
		add(scroll);
		setSize(500, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//���ڵ� ä���ֱ�!!
	//���̺��� �����ϱ� ����, mariadb �����Ͽ� 
	//member ���̺��� ���ڵ带 ������ �迭�� ��Ƴ���!1
	//��?? JTable�� �������� �μ��� ������ �迭�� ���Ǵϱ�!!
	public void loadData(){
		/*
		 * 1�ܰ�-����̹� �ε�
		 * 2�ܰ�-����
		 * 3�ܰ�-���ϴ� ������ ����
		 * 4�ܰ�-�����ͺ��̽� �ݱ�
		 */
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con!=null){
				String sql="select *from member";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				//������ �迭 ����
				data= new String[3][3];
				int index=0;
				while(rs.next()){
					//primary key����
					int member_id=rs.getInt("member_id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					data[index][0]=Integer.toString(member_id);
					data[index][1]=name;
					data[index][2]=Integer.toString(age);
					index++;
				}
			}else{
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
	public static void  main(String[] args){
		new TableTest();
	}

}
