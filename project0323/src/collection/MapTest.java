/*
 * �÷��� �����ӿ� �� �������� ���Ե���
 * key-value ������ �����ϴ� Map�� �н��Ѵ�.
 */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args){
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("wanbaram", "������");
		map.put("wanbaram2", "������2");
		map.put("wanbaram3", "������3");
		
		//��� ��ü ���
		Set set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String id=it.next();
			String value=map.get(id);
			System.out.println(value);
		}
		
		
		
	
	}

}
