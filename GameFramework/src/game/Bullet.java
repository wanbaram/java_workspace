package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject{
	
	public Bullet(ObjectManager objectManager,int x, int y, int width, int height ) {	
		super(objectManager,x,y,width,height);
	}
	public void tick(){
		velX=2;
		x+=velX;
	}
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x,y, width, height);
		
	}



}
