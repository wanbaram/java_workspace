package com.ss.gui;

import javax.swing.JButton;

public class ArrayTest {
	//�ڹٸ� ������ ��κ��� ���� ���α׷�
	//������ �迭 �����, �ݵ�� �� ũ�⸦ 
	//����ؾ� �Ѵ�!!
	public static void main(String[] args) {
		JButton[] arr = new JButton[3];
		arr[0]= new JButton("��ư1");
		arr[1]= new JButton("��ư2");
		arr[2]= new JButton("��ư3");
		for(int i=0;i<arr.length; i++){
		System.out.println(arr[i].getText());
		}
	}

}
