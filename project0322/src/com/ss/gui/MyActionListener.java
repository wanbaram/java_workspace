package com.ss.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	MyKeyListener mykeylistener;
	MyWin mywin;
	public void setMyWin(MyWin mywin){
		this.mywin=mywin;
	}
	public void setMyKeyListener(MyKeyListener mykeylistener){
		this.mykeylistener=mykeylistener;
	}
	public void actionPerformed(ActionEvent e) {
		mywin.text.setText("³ª ´­·¶¾î?");
	}
	

}
