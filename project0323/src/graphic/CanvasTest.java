/*
 * 그림 그려질 목적으로 지원되는 객체인 Canvas에
 * 그림을 그려보자!! 왜 켄버스에 그려야 하나?
 * 켄버스는 컨테이너 처럼 아무것도 없기 때문...
 * 비어 있다. 빈 도화지를 표현한 객체이므로...
 */
package graphic;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class CanvasTest extends JFrame{
	Canvas can;//텅 빈 도화지!!
	Toolkit kit;//JavaSE에서 이미지를 얻으려면
	//툴킷 객체를 이용해야 한다
	Image img;
	//kit으로 부터 얻어와야함
	public CanvasTest() {
		//피곤하면 여기서 오버라이트하자!!
		//내부 익명 클래스!!
		kit=Toolkit.getDefaultToolkit();//인스턴스 얻기
		img=kit.getImage("C:/html_workspace/images/bomb.png");
		can = new Canvas(){
			//paint 메서드는 사실상 행위에 불과하며 어떤그림을
			//그릴지를 결정하는 객체는 
			//Graphics 객체이다!!
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
