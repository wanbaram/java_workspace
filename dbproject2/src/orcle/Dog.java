//������ Ŭ������ �ν��Ͻ��� ���� 1�� �����
//singleTon pattern ���� ���� �� �ϳ���...	
/*
 * javaSE,
 * javaEE��ޱ��(javaSE�� �����Ͽ� ����� ���ø����̼� ���ۿ� ����)
 * 
 */
package orcle;

public class Dog {
	static private Dog instance;
	
	//new�� ���� ������ ����!!
	private Dog(){
	}
	
	static public Dog getInstance() {
		if(instance==null){
			instance=new Dog();
		}
		return instance;
	}
}
