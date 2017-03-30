/*
 * �� Ŭ������ sun���� ��ü ������ UI������Ʈ�� �ƴϱ�
 * ������ ȭ�鿡 �׷��� �� ����.
 * ���� JPanel�� �׷������� Jpanel�� Graphics��
 * ���۷����� �̰�ü�� �����ؾ� �Ѵ�.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{


	public Player(ObjectManager objectManager,int x, int y, int width, int height ) {
		super(objectManager,x,y,width,height);
		
	}
	public void fire(){
		Bullet bullet= new Bullet(objectManager,x,y, 10, 10);
		objectManager.addObject(bullet);
	}
	//x,y,width,height���� ������ ���� ��ȭ�� 
	//�����ϱ� ���� �޼���!!(��� ����-��� ��ȭ)
	public void tick(){
		x+=velX;
		y+=velY;
		
	}
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼���!!
	public void render(Graphics g) {
		g.setColor(Color.WHITE);//����Ʈ ���ٲٱ�
		g.drawRect(x, y, width, height);
		
		
	}

}
