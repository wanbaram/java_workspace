package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCreator extends JFrame{
	JPanel p_north;
	JPanel p_south;
	JButton bt1;
	JButton bt2;
	int count=0;
	ArrayList list= new ArrayList();//���� �迭!!
	//ũ�⸦ ������� �ʾƵ� ��� ��ü���� �ٷ�
	/*
	 * ���ݱ��� ����ؿԴ� �迭�� �뷮�� �����͸� �����ְ� ó���Կ� �־
	 * ��û�� �̵��� ��Դ�.. ������ c,c##,�ڹٿ� ���� ���� ���α׷�������
	 * �迭 ������ �� ũ�⸦ �ݵ�� ����ؾ� �Ѵٴ� Ư¡+�迭�� �����
	 * �ڷ����� �����Ǿ�� �Ѵٴ� �� ���� �� ������ �������� ��������.
	 * �ڹٿ����� �뷮�� ��ü(�ڡڡڡڡڡڡڡڡڡڡڡڡ�)�� ó���ϴ� �� ������ ���̺귯����
	 * �����ϴ� �� �̷��� ���̺귯���� ������ �÷��� �����ӿ��̶� �ϰ�, java.util��Ű���� 
	 * �� �ִ�.  
	 * �ڹ��� collection framework���� �����ϴ� ��ü�� �� ���� ����ϱ� 
	 * ���� ��� ����Ѵٴ� ���� ��û�� ���̴�...
	 * ������ ���� �׶����� ������ ���� �����ϸ� �ȴ�. 
	 * ����!1
	 * �÷��� �����ӿ��� ����� �Ǵ� ���� ���� �繰�� ��ü�� �����ȴ�!!!
	 * �迭�� ������, ��Ƽ� ó���ϴ� �� ���� 
	 * �����ӿ� ���� set,list,map
	 */

	public ButtonCreator(){
		p_north=new JPanel();
		p_south=new JPanel();
		bt1=new JButton("����");
		bt2=new JButton("����");
		p_north.add(bt1);
		p_north.add(bt2);
		add(p_north,BorderLayout.NORTH);
		add(p_south,BorderLayout.CENTER);
		//�̺�Ʈ ����
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createButton();
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��� ��ư�� ������� ���� ����
				setColor();
			}
		});
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//��ư ���� �޼���!!
		//�ǰ��Կ���,������ �� ������?
		//�̺�Ʈ�� �����Ͽ� ������ �ۼ��ϸ�
		//�̺�Ʈ ����� ���濡 ���� ������ �ջ� �����ϱ�..
	}
	public void createButton(){
		count++;
		JButton bt= new JButton(Integer.toString(count));
		//javascript�� push()�� ���� ����� 
		//�޼��� ȣ���ϴ�!!
		list.add(bt);//1�� �߰�
		System.out.println("������� �������� "+list.size());
		p_south.add(bt);
		p_south.updateUI();	
	}
	public void setColor(){
		for(int i=0; i<list.size(); i++){
			JButton bt=(JButton)list.get(i);
			bt.setBackground(Color.YELLOW);
		}
	}
	public static void main(String[] args) {
		new ButtonCreator();
	}
	

}
