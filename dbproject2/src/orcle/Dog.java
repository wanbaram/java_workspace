//강아지 클래스의 인스턴스를 오직 1개 만들기
//singleTon pattern 개발 패턴 중 하나임...	
/*
 * javaSE,
 * javaEE고급기술(javaSE를 포함하여 기업용 어플리케이션 제작에 사용됨)
 * 
 */
package orcle;

public class Dog {
	static private Dog instance;
	
	//new에 의한 생성을 막자!!
	private Dog(){
	}
	
	static public Dog getInstance() {
		if(instance==null){
			instance=new Dog();
		}
		return instance;
	}
}
