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
	ArrayList list= new ArrayList();//완전 배열!!
	//크기를 명시하지 않아도 대고 객체만을 다룸
	/*
	 * 지금까지 사용해왔던 배열은 대량의 데이터를 순서있게 처리함에 있어서
	 * 엄청난 이득을 줘왔다.. 하지만 c,c##,자바와 같은 응용 프로그램에서는
	 * 배열 생성시 그 크기를 반드시 명시해야 한다는 특징+배열은 선언시
	 * 자료형이 결정되어야 한다는 점 등이 은 오히려 유연성이 떨어진다.
	 * 자바에서는 대량의 객체(★★★★★★★★★★★★★)를 처리하는 데 유용한 라이브러리를
	 * 제공하는 데 이러한 라이브러리를 가리켜 컬렉션 프레임웍이라 하고, java.util패키지에 
	 * 모여 있다.  
	 * 자바의 collection framework에서 제공하는 객체는 그 수가 상당하기 
	 * 때에 모두 사용한다는 것은 멍청한 짓이다...
	 * 업무에 따라 그때마다 적절한 것을 적용하면 된다. 
	 * 주의!1
	 * 컬렉션 프레임웍의 대상이 되는 것은 오직 사물인 객체에 한정된다!!!
	 * 배열과 공통점, 모아서 처리하는 데 유용 
	 * 프레임웍 유형 set,list,map
	 */

	public ButtonCreator(){
		p_north=new JPanel();
		p_south=new JPanel();
		bt1=new JButton("생성");
		bt2=new JButton("색깔");
		p_north.add(bt1);
		p_north.add(bt2);
		add(p_north,BorderLayout.NORTH);
		add(p_south,BorderLayout.CENTER);
		//이벤트 구현
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createButton();
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//모든 버튼을 대상으로 배경색 변경
				setColor();
			}
		});
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//버튼 생성 메서드!!
		//피곤함에도,별도로 뺀 이유는?
		//이벤트에 의존하여 로직을 작성하면
		//이벤트 방식의 변경에 의해 로직도 손상 받으니깐..
	}
	public void createButton(){
		count++;
		JButton bt= new JButton(Integer.toString(count));
		//javascript의 push()와 완전 비슷한 
		//메서드 호출하다!!
		list.add(bt);//1건 추가
		System.out.println("현재까지 누적수는 "+list.size());
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
