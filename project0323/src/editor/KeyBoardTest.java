/*
 * Ű���带 
 */
package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {

	public static void main(String[] args) {
		/*
		 * keyboard�� �����ڰ� ���� �� �����Ҽ� �ִ� ��Ʈ���� �ƴ϶�
		 * �̹� �ý��ۿ��� ��ǻ�� �Ӷ� �̸� ������ ������
		 * �����ڴ�  
		 * �ڹٿ����� os�κ��� ��Ʈ���� �̹�
		 * ���ͼ� SystemŬ������ ���������
		 * in������ �޾Ƴ��Ҵ�.. 
		 * 
		 * �ڹٴ� �ϵ��� ������������ �ʰ�
		 * ���� �ϵ���� ��ü�� �� �ý����� ��ϴ�
		 * OS�� �����ϹǷ�, �ϵ��� ���� 
		 * �Է� ��Ʈ���� �ڹٰ� �ƴ� OS�� �̹� ���� �س��� �ִ�.
		 * ���� �ڹ� �� �̿��Ͽ� Ű����, ��ĳ��,,����� �Է��ϵ�
		 * ������ ���� ��� ���ؼ��� �� �ϵ��� �˸��� ��Ʈ�� Ŭ������
		 * �����Ǵ� �� �ƴ϶�, ���� ǥ�� �Է½�Ʈ����
		 * InputStream�� ���� �ȴ�
		 */
		InputStream is= System.in;
		int data;
		try {
			//read()�޼���� ������� �Է���
			//���������� �� ���¿� ������!!
			//�����¶� �����¸� ���Ѵ�!!
			while(true){
			data=is.read();	//1byte �б�
			System.out.print((char)data);
			//ǥ�� ����� ��Ʈ���� ��ǻ�� ų������ Ȱ��ȭ �Ǿ��ֱ� ������
			//�����⸸ �ϸ�  �ȴ�.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//try catch
		

	}

}
