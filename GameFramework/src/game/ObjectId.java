/*
 * 자바에서 지원되는 객체 중, 상수만을 모아놓은 집합을 enum객체라 한다.
 * enum객체는 상수를 모아놓기 때문에 이 상수값들 사이에 index가 존재하여
 * 배열처럼 사용할 수도 있다. 
 */
package game;

public enum ObjectId {
	Player, Enemy, Block, Bullet, Item;

}
