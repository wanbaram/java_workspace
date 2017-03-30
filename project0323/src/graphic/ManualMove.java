package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ManualMove extends JFrame{
	JPanel p_container;
	JButton bt;
	int x=50;
	int y=50;
	public ManualMove() {
		p_container=new JPanel(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		bt= new JButton("움직이기");
		add(p_container,BorderLayout.CENTER);
		add(bt,BorderLayout.NORTH);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move();
			}
		});
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void move(){
		x+=5;
		y+=5;
		repaint();//윈도우!!!

	}
	public void test(){
		System.out.println("호출");
	}
	public static void main(String[] args){
		new ManualMove();
	}

}
