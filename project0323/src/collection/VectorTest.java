/*
 * 컬렉션 프레임웍의 aip객체 중 List계열의 하위 객체인
 * Vector를 학습해뽀자!!
 *참고)List계열은 사실 우리가 흔히 써왔던 배열과 거의 같다
 *
 *					배열									List
 크기: 		반드시 명시								크기 명시 불필요
 대상:		자바기본자료형+객체형						오직 객체형

e는 존재하지 않는다 object형 용도를 말하는 것이다. 
 */
package collection;

import java.util.Vector;

import javax.swing.JButton;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//컬렉션 프레임웍 객체에 Generic Type을
		//명시하면, 객체가 섞이는 것을 
		//컴파일 타임에 방지해준다!!
		//Generic Type을 명시
		//Generic을 하면 형변환 할 필요가 없다.
		Vector<String> v=new Vector<String>();
		v.add("사과");
		v.add("나 버튼");
		v.add("바나나");
		v.add("오렌지");
		for(int i=0; i<v.size();i++){
		Object obj =v.get(i);
		System.out.println(obj);
		}

	}

}
