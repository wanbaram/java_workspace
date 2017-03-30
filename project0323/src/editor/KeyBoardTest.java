/*
 * 키보드를 
 */
package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {

	public static void main(String[] args) {
		/*
		 * keyboard는 개발자가 원할 때 생성할수 있는 스트림이 아니라
		 * 이미 시스템에서 컴퓨터 켤때 미리 얻어놓기 때문에
		 * 개발자는  
		 * 자바에서는 os로부터 스트림을 이미
		 * 얻어와서 System클래스의 멤버변수인
		 * in변수에 받아놓았다.. 
		 * 
		 * 자바는 하드웨어를 직접제어하지 않고
		 * 또한 하드웨어 자체는 현 시스템을 운영하는
		 * OS가 제어하므로, 하드웨어에 대한 
		 * 입력 스트림은 자바가 아닌 OS가 이미 제어 해놓고 있다.
		 * 따라서 자바 언어를 이용하여 키보드, 스캐너,,등등의 입력하드
		 * 웨어의 값을 얻기 위해서는 각 하드웨어에 알맞은 스트림 클래스가
		 * 지원되는 게 아니라, 오직 표준 입력스트림인
		 * InputStream을 쓰면 된다
		 */
		InputStream is= System.in;
		int data;
		try {
			//read()메서드는 사용자의 입력이
			//있을떄까지 블럭 상태에 빠진다!!
			//블럭상태란 대기상태를 말한다!!
			while(true){
			data=is.read();	//1byte 읽기
			System.out.print((char)data);
			//표준 입출력 스트림은 컴퓨터 킬때부터 활성화 되어있기 때문에
			//얻어오기만 하면  된다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//try catch
		

	}

}
