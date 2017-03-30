/*
���� ó���� ����
-������ ������ ����(�� �������� �ý��� ��� ����)

�Ϲ������� ���α׷��� ���� ����� �� ���� ��Ȳ�� ������ "����"�� ��
sun������ ������ ���� ���� �з���
1.���α׷��Ӱ� ��ó�� �� ���� �Ұ��׷��� ����
 Error
2.���α׷��Ӱ� ��ó�� �� �ִ� ���� (���� ��)
	�ڹ��� ���� ������ �ٷ� "����"�̴�.
	sun������ �� ���ܸ� ���׿� ���� ü������ Ŭ������ �����ϰ� �ִ�.
	�� ���� ��ü���� �ٽ� ũ�� 2���� �������� �з�
	(1)������ Ÿ�ӿ� ����ó���� �����ϴ� ���
		checked Exception
	(2)������ Ÿ�ӿ� ����ó���� �������� �ʴ� ���
		Unchecked Exception= Runtiome Exception
*/
package copy;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.FileOutputStream;
class FileCopy2{
	FileInputStream fls;     //������ ������� �� �Է½�Ʈ��
	FileOutputStream fos;	//������ ������� �� ��½�Ʈ��
	public FileCopy2(){
		//�Ʒ��� �ڵ�� ����,������ �߻��� �� �ִ�
		//���ɼ��� �ִ� �ڵ��̴�.. ���� �����ڰ�
		//������ �� �ۼ��������� �ұ��ϰ�, Ư���� 
		//������ġ�� �����ѱ⸦ �����Ѵ�!!
		try{
			fls=new FileInputStream("C:/java_workspace2/project0323/res/bg1.png");
			fos=new FileOutputStream("C:/java_workspace2/project0323/data/bg_copy.png");
			//System.out.println("������ ��Ʈ�� �����߾��!!");
			int data;
			while(true) {
				data=fls.read();//1byte�� �о� �帲
				fos.write(data);//1byte�� ����
				if(data==-1){
					break;
				}
				System.out.println(data);
			}
		}catch(FileNotFoundException e){//������ �߻��ϸ� ����ΰ� �� �������� ����
			//catch���� �����ϰ� �Ǹ� ���α׷��� ���������ᰡ
			//���� �ʰ� ��������� �ϰ� �ȴ�.. ����ڿ��� �ȳ��ϴ� 
			//�뵵�� catch���� ����ϰ� �ȴ�..
			System.out.println("������ ã���� �����ϴ�.");
		}catch(IOException e){
			System.out.println("������ ���� �� �����ϴ�.");
		}finally{
			//��� ������ ���� ����
			//finally�� �����ϸ�,
			//try���� �����ϴ�, catch���� �����ϴ�
			//����ΰ� ������ �� ������ ���ļ� ����.
			//finally�ڵ��� ������
			/*
				�ַ� database������ ��Ʈ�� ����
				�������θ� ������ ������ �ڿ��� �ݰų�
				������ �Ϸ��� try���̴� catch���� �����ϴ�
				������� ������ ���İ����� �ڵ� ������ �α� ����

			*/
			try{
				if(fls!=null){
					fls.close();//�Է½�Ʈ�� ���� ����!!
				}
				if(fos!=null){
					fos.close();//��½�Ʈ�� ���� ����!!
				}
			}catch(IOException e){

			}
		}
		//��� ������ ������ ����!!\

	}
	public static void main(String[] args){
		new FileCopy2();
	}
}