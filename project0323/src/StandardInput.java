/*
 * 1��Ʈ���� ���⼺�� ���� �з�
 * -�Է�,���
 * 2.��Ʈ���� ������ ó������� ���� �з�
 * (1) ����Ʈ ��� ��Ʈ��
 * 	(����½� 1byte�� ó��)
 * (2) ���� ��� ��Ʈ��
 * (����½� 2byte�� ������ ������ �� �ִ� ��Ʈ��)
 * ����!!2byte�� �аų�, ���°� �ƴϴ�!!!
 * ���ڱ�ٽ�Ʈ���� ������
 * ���ڽ�Ʈ�� ~~~Reader�� ����
 * 					Writer�ι���
 * 
 *
 * (3) ���� ��Ʈ��
 * 
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		//��Ʈ�� ���!!
		InputStream is= System.in;
		InputStreamReader reader= null;
		reader = new InputStreamReader(is);
		int data;
		try {
			//while(true){
			data=reader.read();//1byte
			System.out.print((char)data);
			//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
