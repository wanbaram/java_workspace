/*
 * �÷��� �����ӿ��� ���� 2���� �� �������� ��ü���� ������
 * set������ �˾ƺ���
 */
package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		//set�ڽĵ��� TreeSet�� ����غ���.
		TreeSet<String> set= new TreeSet<String>();
		set.add("����");
		set.add("������");
		set.add("����");
		//�÷��� �����ӿ��� ��ü �� �������� ��ü�� ����ϴ� ����,
		//�뷮�� ó���� �ݺ����� ���� ����Ҽ����ٴ� ����� �ε�ģ��
		//�ذ�å) �������� ����--> �����ְ� ������
		// 			Enumeration,Iterator
		//�ݺ������� for,while���� �ִ�
		//for���� ���۰� ������ ��ġ�� �˰����� ��
		//�����ϴ� 1~256����
		/*
		 * While���� �Ұ�ȣ���� true���� �����Ѵ�
		 * int i=0;
		 * while(true){
		 * 		i++;
		 * 	if(i<=256){
		 * }
		 * }
		 */
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String e1=it.next();//���� ��ҿ� ����;
			System.out.println(e1);
		}
	}

}
