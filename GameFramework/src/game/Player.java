/*
 * 이 클래스는 sun에서 자체 제작한 UI컴포넌트가 아니기
 * 때문에 화면에 그려질 수 없다.
 * 따라서 JPanel에 그려지려면 Jpanel의 Graphics의
 * 레퍼렌스를 이객체가 보유해야 한다.
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
	//x,y,width,height등의 물리량 등의 변화를 
	//제어하기 위한 메서드!!(사람 비유-운동량 변화)
	public void tick(){
		x+=velX;
		y+=velY;
		
	}
	//변화된 값을 화면에 그려지게 할 메서드!!
	public void render(Graphics g) {
		g.setColor(Color.WHITE);//페인트 색바꾸기
		g.drawRect(x, y, width, height);
		
		
	}

}
