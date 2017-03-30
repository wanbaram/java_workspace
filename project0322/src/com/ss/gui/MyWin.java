package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyWin extends JFrame{
	JTextField text;
	JButton bt;
	JPanel p;
	MyActionListener myactionlistener;
	MyKeyListener mykeylistener;
    public MyWin(){
    	text=new JTextField(15);
    	bt= new JButton("´­·¯ºÁ");
    	p=new JPanel();
    	myactionlistener= new MyActionListener();
    	mykeylistener= new MyKeyListener();
    	p.add(bt);
    	add(text,BorderLayout.NORTH);
    	add(p,BorderLayout.CENTER);
    	bt.addActionListener(myactionlistener);
    	text.addKeyListener(mykeylistener);
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		myactionlistener.setMyWin(this);
    }
    public static void main(String[] args){
    	new MyWin();

    }

}
