/*
 * 컬렉션 프레임웍 중 순서없는 개게들을
 * key-value 쌍으로 관리하는 Map을 학습한다.
 */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args){
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("wanbaram", "정영진");
		map.put("wanbaram2", "정영진2");
		map.put("wanbaram3", "정영진3");
		
		//모든 객체 출력
		Set set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String id=it.next();
			String value=map.get(id);
			System.out.println(value);
		}
		
		
		
	
	}

}
