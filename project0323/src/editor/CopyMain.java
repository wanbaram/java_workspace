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
	FileInputStream fis;//파일을 대상으로 한 입력스트림
	FileOutputStream fos;//파일을 대상으로 한 출력스트림
	JFileChooser chooser;//파일탐색기를 처리하는 객체
	String oriPath, destPath;
	public CopyMain() {
		bt_open=new JButton("원본경로");
		bt_save=new JButton("저장경로 ");
		bt_copy=new JButton("복사실행");

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

		//파일 추저를 미리 올려놓자!!
		chooser = new JFileChooser("C:/java_workspace2/project0323");

		setSize(505,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();//이벤트 소스를 반환 받는다!!
		if(obj==bt_open){
			System.out.println("열기");
			open();
		}else if(obj==bt_copy){
			System.out.println("복사실행");
			copy();
		}else if(obj==bt_save){
			System.out.println("저장할 경로 지정");
			save();
		}

	}

	//파일 열기
	public void open(){
		int state=chooser.showOpenDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
			//파일클래스가 보유한 절대경로 메서드
			//를 이용하여 경로 반환!!
			
			//유저가 선택한 파일에 대한 파일 클래스 인스턴스 열기!!
			File file=chooser.getSelectedFile();
			//언어진 인스턴스를 이용하여 절대경로얻기
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
	//복사하기
	public void copy(){
		//원본파일에 스트림 생성하여, 데이터를 들이마시자
		//들어온 데이터를 목적파일에 내려쓰자!!
		oriPath=t_open.getText();
		destPath=t_save.getText();
		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(destPath);
			int data;
			while(true){
				data=fis.read();//현재 실행중인 프로그램으로 1byte 읽어들임!!
				if(data==-1){break;
				}
				fos.write(data);
			}
			//JOptionPane.showMessageDialog(this, "복사완료");
			
			//스트림을 닫자
			//try문 안에서 닫을 경우 문제점
			
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "파일이 찾을 수 없습니다");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO 작업 중 에러발생했네요");
		}finally{
			try{
				//객체가 메모리에 올라왔다면...
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
