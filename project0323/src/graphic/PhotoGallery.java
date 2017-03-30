package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhotoGallery extends JFrame{
	JLabel lb;
	Canvas can;
	JPanel p;
	JButton b_pre;
	JButton b_next;
	Toolkit kit;
	Image[] img= new Image[8];
	int count=0;
	public PhotoGallery() {
		lb=new JLabel("");
		p=new JPanel();
		b_pre= new JButton("¢¸");
		b_next= new JButton("¢º");
		kit=Toolkit.getDefaultToolkit();
		/*for(int i=0; i<img.length; i++){
			img[i]=kit.getImage("C:/html_workspace/images/bg+'i'+.png");
		}*/
		img[0]=kit.getImage("C:/html_workspace/images/bg0.png");
		img[1]=kit.getImage("C:/html_workspace/images/bg1.png");
		img[2]=kit.getImage("C:/html_workspace/images/bg2.png");
		img[3]=kit.getImage("C:/html_workspace/images/bg3.png");
		img[4]=kit.getImage("C:/html_workspace/images/bg4.png");
		img[5]=kit.getImage("C:/html_workspace/images/bg5.png");
		img[6]=kit.getImage("C:/html_workspace/images/bg6.png");
		img[7]=kit.getImage("C:/html_workspace/images/bg7.png");
		can= new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img[count],0, 0, 600, 600,this);
				//lb.setText();
			}
		};
		add(lb,BorderLayout.NORTH);
		add(can,BorderLayout.CENTER);
		p.add(b_pre);
		p.add(b_next);
		b_pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count>0){
					count--;		
				}
				can.repaint();
			}
		});
		b_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count<7){
				count++;
				}
				can.repaint();
			}
		});
		add(p,BorderLayout.SOUTH);
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new PhotoGallery();
		
	}

}
