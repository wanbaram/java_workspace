package com.ss.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAdapter extends WindowAdapter{
	/*�����Ͱ� �̹� 7���� ��� �������̵� �߱� ������
	 * �츮�� ���̻� ���� ������ ���� �ʴ� �����̴�.!!
	 * �� �߿��� ���ϴ� �޼��带 �� �������̵� ����!!
	 * */
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	

}
