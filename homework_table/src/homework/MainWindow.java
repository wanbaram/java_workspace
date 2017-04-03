package homework;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.temporal.ValueRange;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainWindow extends JFrame implements ItemListener{
	JPanel p_west,p_emp,p_dept,p_container;
	Choice ch;
	JTable t_dept,t_emp;
	JScrollPane scroll;
	public MainWindow() {
		p_west=new JPanel();
		p_dept=new JPanel();
		p_emp=new JPanel();
		p_container=new JPanel();
		ch=new Choice();
		p_west.add(ch);
		p_west.setBackground(Color.BLUE);
		t_dept=new JTable(new DeptTable());
		t_emp=new JTable(new EmpTable());
		//scroll= new JScrollPane(t_dept);
		//scroll= new JScrollPane(t_emp);
		p_dept.add(t_dept);
		p_emp.add(t_emp);
		
		p_container.add(p_dept);
		p_container.add(p_emp);
		ch.addItem("테이블을 고르시오");
		ch.addItem("dept");
		ch.addItem("emp");
		ch.addItemListener(this);
		add(p_west, BorderLayout.WEST);
		add(p_container, BorderLayout.CENTER);
		p_dept.setVisible(false);
		p_emp.setVisible(false);
		
		setSize(1000, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		int num=ch.getSelectedIndex();
		if(num==1){
			OpenDeptTable();
		}else if(num==2){
			OpenEmpTable();
		}else if(num==0){
			CloseTable();
		}
	}
	public void OpenDeptTable(){
		p_dept.setVisible(true);
		p_emp.setVisible(false);
		
	}
	public  void OpenEmpTable(){
		p_dept.setVisible(false);
		p_emp.setVisible(true);
	}
	public  void CloseTable(){
		p_dept.setVisible(false);
		p_emp.setVisible(false);
	}
	public static void main(String[] args) {
		new MainWindow();

	}




}
