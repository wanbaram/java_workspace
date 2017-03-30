/*
 * 게임에 등장할 모든 객체의 최상위 클래스를 정의한다!!
 * 왜?? 상속을 이용하면 코드 중복을 방지할 수 있고
 * 최상위 클래스 자료형으로 자식들을 가리킬수 있으므로
 * 코드가 유연해진다!!
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
