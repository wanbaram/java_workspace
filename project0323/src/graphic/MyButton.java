/*
 *��ư Ŭ������ final�� ����Ǿ� ���� �����Ƿ� �翬�� ����� �����ϴ�!! 
 */
package graphic;

import java.awt.Graphics;

import javax.swing.JButton;

public class MyButton extends JButton{
	//��Ӱ���� �θ��� �����ڴ� �������� �ʴ´�!!
	public MyButton(String title) {
		super(title);//�θ��� ������ ȣ��!!
	}
	//��� ������Ʈ�� �����θ� �׸��Ƿ�, 
	//�̶� ���Ǵ� �޼��尡 paint �޼����̸�
	//�� �޼��带 �����ڰ� �������̵� �Ѵٸ�
	//�����ڰ� ��ư�� �׸��� �ȴ�.
	//sun���� �����ϴ� ������Ʈ �� �����ڰ� 
	//�״�� ����ؾ��� ���� �ְ�, �����ڰ� �ֵ��Ͽ�
	//�׷��� ó���� �ؾ� �� ���� �ִ�..
	//������Ʈ �� �����ڰ� ���𰡸� �׸��� �뵵��
	//������Ʈ�� JPanle, JFrame�� �ַ� �����̳�
	//���� ������� ����!!
	//Canvas�� �׸� �׸� ����� �������� ������
	@Override
	public void paint(Graphics g) {
		System.out.println("�׷���!!");
	}
}
