/*
 * �÷��� �����ӿ��� aip��ü �� List�迭�� ���� ��ü��
 * Vector�� �н��ػ���!!
 *����)List�迭�� ��� �츮�� ���� ��Դ� �迭�� ���� ����
 *
 *					�迭									List
 ũ��: 		�ݵ�� ���								ũ�� ��� ���ʿ�
 ���:		�ڹٱ⺻�ڷ���+��ü��						���� ��ü��

e�� �������� �ʴ´� object�� �뵵�� ���ϴ� ���̴�. 
 */
package collection;

import java.util.Vector;

import javax.swing.JButton;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�÷��� �����ӿ� ��ü�� Generic Type��
		//����ϸ�, ��ü�� ���̴� ���� 
		//������ Ÿ�ӿ� �������ش�!!
		//Generic Type�� ���
		//Generic�� �ϸ� ����ȯ �� �ʿ䰡 ����.
		Vector<String> v=new Vector<String>();
		v.add("���");
		v.add("�� ��ư");
		v.add("�ٳ���");
		v.add("������");
		for(int i=0; i<v.size();i++){
		Object obj =v.get(i);
		System.out.println(obj);
		}

	}

}
