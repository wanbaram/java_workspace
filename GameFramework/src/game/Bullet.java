package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
	
	public Bullet(ObjectManager objectManager,ObjectId id,int x, int y, int width, int height ) {	
		super(objectManager,id,x,y,width,height);
	}
	public void tick(){
		velX=2;
		x+=velX;
		rect.setBounds(x, y, width, height);
		//적군과 내가 교차하면, 둘다 죽기!!
		for(int i=0; i<objectManager.list.size();i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id==ObjectId.Enemy){
				if(obj.rect.intersects(rect)){
				objectManager.list.remove(obj);//너죽고
				objectManager.list.remove(this);
				}
			}
			//rect.intersects();
		}
	}
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height);
		
	}



}
