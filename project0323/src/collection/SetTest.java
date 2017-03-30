/*
 * 컬렉션 프레임웍의 유형 2가지 중 순서없는 객체들의 집합인
 * set유형을 알아보자
 */
package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		//set자식들중 TreeSet을 사용해본다.
		TreeSet<String> set= new TreeSet<String>();
		set.add("딸기");
		set.add("오렌지");
		set.add("레몬");
		//컬렉션 프레임웍의 객체 중 순서없는 객체를 사용하다 보면,
		//대량의 처리시 반복문을 직접 사용할수없다는 어려움에 부딪친다
		//해결책) 순서없는 것을--> 순서있게 만들자
		// 			Enumeration,Iterator
		//반복문에는 for,while문이 있다
		//for문은 시작과 끝값을 수치로 알고있을 때
		//유용하다 1~256까지
		/*
		 * While문은 소괄호안이 true동안 동작한다
		 * int i=0;
		 * while(true){
		 * 		i++;
		 * 	if(i<=256){
		 * }
		 * }
		 */
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String e1=it.next();//다음 요소에 접근;
			System.out.println(e1);
		}
	}

}
