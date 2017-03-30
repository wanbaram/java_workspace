/*
 * 모든 게임은 패널안에서 그려질 예정임
 * 아무리 게임의 장면이 다양하더라도, 패널은 오직 하나이다.
 * 
 * 모든 오브젝트는 결국 이패널에 그려져야 하므로, 이 패널의 paint 메서드의 인수로 
 * 전달되는 Graphics 객체를 게임에 등장할 모든 오브젝트가
 * 전달받아야 한다....
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
	boolean flag= true;//게임 가동 여부를 결정하는 변수
	Thread thread;//게임 운영 쓰레드
	Player player;
	ObjectManager objectManager;//객체 명단 관리자
	public GamePanel() {
		thread=new Thread(this);
		thread.start();
		
		init();
		
		//크기 지정
		setPreferredSize(new Dimension(SCALE*WIDTH, SCALE*HEIGHT));
	}
	public void init(){
		//명단 관리자 생성
		objectManager= new ObjectManager();
		//주인공 등장 시키기
		player=new Player(objectManager,100, 100, 50, 50);
		objectManager.addObject(player);
		//패널과 키보드 리스너 연결
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
			//오브젝트 매니저에 등록된 모든 ~~객체를 대상으로 tick()을 호출해보자!!
			for(int i=0; i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			//player.tick();
			repaint();//paintComponent를 간접 호출
		}
				
	}
	

}
