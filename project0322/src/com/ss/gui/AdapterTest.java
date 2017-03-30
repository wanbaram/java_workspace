package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdapterTest extends JFrame {
	JTextField txt;
	JTextArea area;
	JButton bt;
	public AdapterTest(){
		setLayout(new FlowLayout());
		txt=new JTextField(20);
		area=new JTextArea(20, 30);
		bt=new JButton("�� ��ư");
		add(txt);
		add(area);
		add(bt);
		//txt�� �����ʿ� ����
		//.java������ ����� ���� ���,  Ŭ���� �ڵ� ��ü�� �޼����� �μ���, Ŭ������ �ɹ����� �ٷ� ������
		//�� �ִ�.
		//�����͸�Ŭ������ ����ϴ� ����?
		//Anonymous inner class
		//.java vs �����͸�
		//.java�� ���������� �����ҽ����� �ۼ��ϴ� ������
		//�ڵ��� ���뼺�� �ִ�.. ������, 
		//GUI ���α׷��� ��� Ư�� �̺�Ʈ ����
		//�ڵ�� Ư�� Ŭ������ �������̱� ������ 
		//���뼺�� ����� ��������
		//�̰�� �����ڰ� .java���� ������ �μ��� ���� ��ü�� �Ѱܹ޴� �ؾ��ұ�?
		//�ش�)��ȸ�� �ڵ�� ����!! �� ���� Ŭ������ �Ժη� Ŭ������ ������� �������
		txt.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					String msg=txt.getText();
					area.append(msg + "\n");
					txt.setText("");
				}
			}
		});
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ������?");
			}
		});
		//�����͸� Ŭ������ ����
		//�����͸� �ż��� �ڵ� �ȿ��� �ڽ��� ������
		//�ܺ�Ŭ������ ��������� �� �� ó�� ���� �ִ�. 
		//�ڰ��� ���� ����
		//�����͸�Ŭ������ ������� ��� �̵���
		//��������� ������ �� �ִٴ� ���ε�,
		//���� �����ڰ� ���������� �����͸����� 
		//����ϰ����ҋ��� �� ���������� final��
		//���� �Ǿ� �־�� �Ѵ�..
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new AdapterTest();
	}

}
