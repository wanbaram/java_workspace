package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCreator2 extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_south;
	JButton b_create;
	JButton b_color;
	int count;
	ArrayList list= new ArrayList();
	public ButtonCreator2(){
		p_north=new JPanel();
		p_south=new JPanel();
		b_create=new JButton("버튼 생성");
		b_color=new JButton("색깔변경");
		p_north.add(b_create);
		p_north.add(b_color);
		add(p_north,BorderLayout.NORTH);
		add(p_south,BorderLayout.CENTER);
		b_create.addActionListener(this);
		b_color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<list.size();i++){
					JButton bt=(JButton)list.get(i);
					bt.setBackground(Color.RED);
				}
			}
		});
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		count++;
		JButton bt=new JButton(Integer.toString(count));
		list.add(bt);
		p_south.add(bt);
		p_south.updateUI();
	}
	
	public static void main(String[] args){
		new ButtonCreator2();
	}



}
