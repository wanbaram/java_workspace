/*
 * �׸� �׷��� �������� �����Ǵ� ��ü�� Canvas��
 * �׸��� �׷�����!! �� �˹����� �׷��� �ϳ�?
 * �˹����� �����̳� ó�� �ƹ��͵� ���� ����...
 * ��� �ִ�. �� ��ȭ���� ǥ���� ��ü�̹Ƿ�...
 */
package graphic;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class CanvasTest extends JFrame{
	Canvas can;//�� �� ��ȭ��!!
	Toolkit kit;//JavaSE���� �̹����� ��������
	//��Ŷ ��ü�� �̿��ؾ� �Ѵ�
	Image img;
	//kit���� ���� ���;���
	public CanvasTest() {
		//�ǰ��ϸ� ���⼭ ��������Ʈ����!!
		//���� �͸� Ŭ����!!
		kit=Toolkit.getDefaultToolkit();//�ν��Ͻ� ���
		img=kit.getImage("C:/html_workspace/images/bomb.png");
		can = new Canvas(){
			//paint �޼���� ��ǻ� ������ �Ұ��ϸ� ��׸���
			//�׸����� �����ϴ� ��ü�� 
			//Graphics ��ü�̴�!!
			public void paint(Graphics g) {
				g.drawImage(img,200, 200, 300, 300,this);
				
			}
			
		};
		can.setBackground(Color.YELLOW);
		add(can);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new CanvasTest();
		
	}
}
