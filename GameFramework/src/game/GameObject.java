/*
 * ���ӿ� ������ ��� ��ü�� �ֻ��� Ŭ������ �����Ѵ�!!
 * ��?? ����� �̿��ϸ� �ڵ� �ߺ��� ������ �� �ְ�
 * �ֻ��� Ŭ���� �ڷ������� �ڽĵ��� ����ų�� �����Ƿ�
 * �ڵ尡 ����������!!
 */
package game;

import java.awt.Graphics;

abstract public class GameObject {
	ObjectManager objectManager;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	public GameObject(ObjectManager objectManager,int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		
	}
	abstract public void tick();
	abstract public void render(Graphics g);
	

}
