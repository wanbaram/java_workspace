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
		b_pre= new JButton("��");
		b_next= new JButton("��");
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
		//��ư���� ����!!
		b_pre.addActionListener(this);
		b_next.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e);
		//JOptionPane.showMessageDialog(this, "�� ������?");
		//ActionEvent�� Ŭ���Ӹ� �ƴ϶�, ���� ������ �ƿ츣��
		//�̺�Ʈ ��ü�̴�. ���� ��ư�� ActionEvent�� ����Ű�� �Ծƴϴ�
		//�׷��� e.getSource()ȣ���ϸ�, � ������Ʈ�� �̺�Ʈ�� 
		//�����״��� ������ �� �����Ƿ� 
		//Object������ ��ȯ���ش�!!
		Object obj=e.getSource();//�̺�Ʈ�� ����Ű�� ������Ʈ
		JButton btn=(JButton)obj;
		if(btn==b_pre){//�ּҰ��� �����̶��
			perv();
		}
		if(btn==b_next){//�ּҰ��� �������̶��
			next();
		}
	}
	//�������� �����ֱ�
	public void next(){
		if(count<7){
			count++;
			}
		lb.setText(path[count]);
		img=kit.getImage(path[count]);
		//�����ڴ� paint �޼��带 ȣ�� �� �� ����.
		//paint�� ����ȣ��ǳ�?
		can.repaint();
		//�̹��� ��κ���
	}
	//�������� �����ֱ�
	public void perv(){
		if(count>0){
			count--;
			}
		//���� ������ ������
		lb.setText(path[count]);
		img=kit.getImage(path[count]);
		//�����ڴ� paint �޼��带 ȣ�� �� �� ����.
		//paint�� ����ȣ��ǳ�?
		//������ �ش� ������Ʈ�� ������ ���� �� ������ ȣ��ȴ�!!
		//���� ��ư�� ������ �Ǹ� ������ ���� ���� ���� ������
		//paint�޼���� ȣ����� �ʴ´�.
		//�ذ�å)ĵ������ paint �޼��带 ���� �ؾ� ������,
		//ȣ��Ұ� �̱� �빮�� ���� ȣ���ؾ��Ѵ�...
		//�ý������� paintȣ���ش޶�� ��û�ؾ��Ѵ�.
		//repaint()-->update()-->paint()
		//paint()�޼��尡 �׸��� �ٽ� �׸���..
		//���� �̹��� �뷮�� ū ��쿣 �츮 ����
		//�����Ÿ��� ȿ���� ���� ���̴�!!
		can.repaint();
		//�̹��� ��κ���
		
	}
	
		
	public static void main(String[] args){
		new PhotoGallery2();
		
	}


}
