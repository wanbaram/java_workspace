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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PhotoGallery2 extends JFrame implements ActionListener{
	JLabel lb;
	Canvas can;
	JPanel p;
	JButton b_pre;
	JButton b_next;
	Toolkit kit;
	Image img;
	int count=0;
	String[]path={
			"C:/html_workspace/images/bg0.png",
			"C:/html_workspace/images/bg1.png",
			"C:/html_workspace/images/bg2.png",
			"C:/html_workspace/images/bg3.png",
			"C:/html_workspace/images/bg4.png",
			"C:/html_workspace/images/bg5.png",
			"C:/html_workspace/images/bg6.png",
			"C:/html_workspace/images/bg7.png"
	};
	public PhotoGallery2() {
		lb=new JLabel(path[count]);
		p=new JPanel();
		b_pre= new JButton("◀");
		b_next= new JButton("▶");
		kit=Toolkit.getDefaultToolkit();
		img=kit.getImage(path[count]);
		can= new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img,0, 0, 600, 600,this);
			}
		};
		add(lb,BorderLayout.NORTH);
		add(can,BorderLayout.CENTER);
		p.add(b_pre);
		p.add(b_next);
		//버튼마다 연결!!
		b_pre.addActionListener(this);
		b_next.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e);
		//JOptionPane.showMessageDialog(this, "나 눌렀어?");
		//ActionEvent는 클릭뿐만 아니라, 여러 행위를 아우르는
		//이벤트 객체이다. 따라서 버튼만 ActionEvent를 일으키는 게아니다
		//그래서 e.getSource()호출하면, 어떤 컴포넌트가 이벤트를 
		//일으켰는지 예측할 수 없으므로 
		//Object형으로 반환해준다!!
		Object obj=e.getSource();//이벤트를 일으키는 컴포넌트
		JButton btn=(JButton)obj;
		if(btn==b_pre){//주소갑이 왼쪽이라면
			perv();
		}
		if(btn==b_next){//주소갑이 오른쪽이라면
			next();
		}
	}
	//다음사진 보여주기
	public void next(){
		if(count<7){
			count++;
			}
		lb.setText(path[count]);
		img=kit.getImage(path[count]);
		//개발자는 paint 메서드를 호출 할 수 없다.
		//paint는 언제호출되나?
		can.repaint();
		//이미지 경로변경
	}
	//이전사진 보여주기
	public void perv(){
		if(count>0){
			count--;
			}
		//라벨의 변경을 가하자
		lb.setText(path[count]);
		img=kit.getImage(path[count]);
		//개발자는 paint 메서드를 호출 할 수 없다.
		//paint는 언제호출되나?
		//유저가 해당 컴포넌트의 변경을 가할 때 스스로 호출된다!!
		//따라서 버튼을 누르게 되면 변경을 가한 적이 없기 때문에
		//paint메서드는 호출되지 않는다.
		//해결책)캔버스의 paint 메서드를 강제 해야 하지만,
		//호출불가 이기 대문에 간접 호출해야한다...
		//시스템한테 paint호출해달라고 요청해야한다.
		//repaint()-->update()-->paint()
		//paint()메서드가 그림을 다시 그린다..
		//따라서 이미지 용량이 큰 경우엔 우리 눈엔
		//깜빡거리는 효과가 나는 것이다!!
		can.repaint();
		//이미지 경로변경
		
	}
	
		
	public static void main(String[] args){
		new PhotoGallery2();
		
	}


}
