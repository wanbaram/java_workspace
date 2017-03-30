/*
 * ��� ������ �гξȿ��� �׷��� ������
 * �ƹ��� ������ ����� �پ��ϴ���, �г��� ���� �ϳ��̴�.
 * 
 * ��� ������Ʈ�� �ᱹ ���гο� �׷����� �ϹǷ�, �� �г��� paint �޼����� �μ��� 
 * ���޵Ǵ� Graphics ��ü�� ���ӿ� ������ ��� ������Ʈ��
 * ���޹޾ƾ� �Ѵ�....
 */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	public static final int SCALE=2;
	boolean flag= true;//���� ���� ���θ� �����ϴ� ����
	Thread thread;//���� � ������
	Player player;
	ObjectManager objectManager;//��ü ��� ������
	public GamePanel() {
		thread=new Thread(this);
		thread.start();
		
		init();
		
		//ũ�� ����
		setPreferredSize(new Dimension(SCALE*WIDTH, SCALE*HEIGHT));
	}
	public void init(){
		//��� ������ ����
		objectManager= new ObjectManager();
		//���ΰ� ���� ��Ű��
		player=new Player(objectManager,100, 100, 50, 50);
		objectManager.addObject(player);
		//�гΰ� Ű���� ������ ����
		this.addKeyListener(new KeyBoard(player));
		
	}
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SCALE*WIDTH, SCALE*HEIGHT);
		for(int i=0; i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
		}
	}

	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//������Ʈ �Ŵ����� ��ϵ� ��� ~~��ü�� ������� tick()�� ȣ���غ���!!
			for(int i=0; i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			//player.tick();
			repaint();//paintComponent�� ���� ȣ��
		}
				
	}
	

}
