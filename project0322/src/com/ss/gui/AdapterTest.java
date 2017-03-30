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
		bt=new JButton("나 버튼");
		add(txt);
		add(area);
		add(bt);
		//txt와 리스너와 연결
		//.java파일을 만들기 싫은 경우,  클래스 코드 자체를 메서드의 인수나, 클래스의 맴버변수 바로 대입할
		//수 있다.
		//내부익명클래스를 사용하는 이유?
		//Anonymous inner class
		//.java vs 내부익명
		//.java를 물리적으로 원본소스까지 작성하는 이유는
		//코드의 재사용성에 있다.. 하지만, 
		//GUI 프로그래밍 등에서 특히 이벤트 구현
		//코드는 특정 클래스에 종속적이기 때문에 
		//재사용성이 상당히 떨어진다
		//이경우 개발자가 .java까지 만들어가며 인수를 통해 객체를 넘겨받는 해야할까?
		//해답)일회성 코드로 가자!! 즉 현재 클래스에 입부로 클래스를 존재시켜 사용하자
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
				System.out.println("나 눌렀어?");
			}
		});
		//내부익명 클래스의 장점
		//내부익명 매서드 코드 안에서 자신을 포함한
		//외부클래스의 멤버변수를 내 것 처럼 쓸수 있다. 
		//자격증 시험 문제
		//내부익명클래스의 사용으로 얻는 이득은
		//멤버변수를 공유할 수 있다는 것인데,
		//만일 개발자가 지역변수를 내부익명내에서 
		//사용하고자할떄는 그 지역변수는 final로
		//선언 되어 있어야 한다..
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new AdapterTest();
	}

}
