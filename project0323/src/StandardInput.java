/*
 * 1스트림의 방향성에 따른 분류
 * -입력,출력
 * 2.스트림의 데이터 처리방법에 따른 분류
 * (1) 바이트 기반 스트림
 * 	(입출력시 1byte씩 처리)
 * (2) 문자 기반 스트림
 * (입출력시 2byte씩 묶에서 이해할 수 있는 스트림)
 * 주의!!2byte씩 읽거나, 쓰는게 아니다!!!
 * 문자기바스트림의 명명규직
 * 문자스트림 ~~~Reader로 끝남
 * 					Writer로문자
 * 
 *
 * (3) 버퍼 스트림
 * 
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		//스트림 얻기!!
		InputStream is= System.in;
		InputStreamReader reader= null;
		reader = new InputStreamReader(is);
		int data;
		try {
			//while(true){
			data=reader.read();//1byte
			System.out.print((char)data);
			//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
