package editor;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
public class CopyMain extends JFrame implements ActionListener{
	JButton bt_open,bt_save,bt_copy;
	JTextField t_open,t_save;
	FileInputStream fis;//������ ������� �� �Է½�Ʈ��
	FileOutputStream fos;//������ ������� �� ��½�Ʈ��
	JFileChooser chooser;//����Ž���⸦ ó���ϴ� ��ü
	String oriPath, destPath;
	public CopyMain() {
		bt_open=new JButton("�������");
		bt_save=new JButton("������ ");
		bt_copy=new JButton("�������");

		t_open=new JTextField("",30);
		t_save=new JTextField("",30);
		
		setLayout(new FlowLayout());
		
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		//���� ������ �̸� �÷�����!!
		chooser = new JFileChooser("C:/java_workspace2/project0323");

		setSize(505,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();//�̺�Ʈ �ҽ��� ��ȯ �޴´�!!
		if(obj==bt_open){
			System.out.println("����");
			open();
		}else if(obj==bt_copy){
			System.out.println("�������");
			copy();
		}else if(obj==bt_save){
			System.out.println("������ ��� ����");
			save();
		}

	}

	//���� ����
	public void open(){
		int state=chooser.showOpenDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
			//����Ŭ������ ������ ������ �޼���
			//�� �̿��Ͽ� ��� ��ȯ!!
			
			//������ ������ ���Ͽ� ���� ���� Ŭ���� �ν��Ͻ� ����!!
			File file=chooser.getSelectedFile();
			//����� �ν��Ͻ��� �̿��Ͽ� �����ξ��
			String Path=file.getAbsolutePath();
			t_open.setText(Path);
		}
		
	}
	public void save(){
		chooser.showSaveDialog(this);
		File openPath=chooser.getSelectedFile();
		String openPath2=openPath.getAbsolutePath();
		t_save.setText(openPath2);
	}
	//�����ϱ�
	public void copy(){
		//�������Ͽ� ��Ʈ�� �����Ͽ�, �����͸� ���̸�����
		//���� �����͸� �������Ͽ� ��������!!
		oriPath=t_open.getText();
		destPath=t_save.getText();
		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(destPath);
			int data;
			while(true){
				data=fis.read();//���� �������� ���α׷����� 1byte �о����!!
				if(data==-1){break;
				}
				fos.write(data);
			}
			//JOptionPane.showMessageDialog(this, "����Ϸ�");
			
			//��Ʈ���� ����
			//try�� �ȿ��� ���� ��� ������
			
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO �۾� �� �����߻��߳׿�");
		}finally{
			try{
				//��ü�� �޸𸮿� �ö�Դٸ�...
				if(fis!=null){
				fis.close();
				}
				if(fos!=null){
				fos.close();
				}
			}catch(IOException e){
			}
		}
	}

	public static void main(String[] args) {
		new CopyMain();

	}

}
