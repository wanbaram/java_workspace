package com.ss.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyKeyAdpater extends KeyAdapter{
	AdapterTest my;
	JTextArea area;
	JTextField txt;
	public MyKeyAdpater(JTextArea area, JTextField txt){
		this.area=area;
		this.txt=txt;
	}
	public void keyPressed(KeyEvent e) {
		//area에 txt의 입력한 문자열 출력
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER){
			String msg=txt.getText();
			area.append(msg + "\n");
			txt.setText("");
		}
		
	}

}
