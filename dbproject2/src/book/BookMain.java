package book;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookMain extends JFrame implements ItemListener,ActionListener{
	JPanel p_west;//���� �����
	JPanel p_content;//���� ���� ��ü
	JPanel p_north;//���� ���� ��� ����
	JPanel p_center;//JTable�� �ٿ��� �г�
	JPanel p_grid;//�׸��� ������� ������ �г�
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_price;
	Canvas can;
	JButton bt_regist;
	CheckboxGroup group;
	Checkbox ch_table,ch_grid;
	DBManager manager;
	Connection con;
	Toolkit kit= Toolkit.getDefaultToolkit();
	Image img;
	JFileChooser chooser;
	public BookMain() {
	
		manager=DBManager.getInstance();
		p_west=new JPanel();
		p_content= new JPanel();
		p_north= new JPanel();
		p_center= new JPanel();
		p_grid= new JPanel();
		ch_top= new Choice();
		ch_sub= new Choice();
		t_name=new JTextField(10);
		t_price=new JTextField(10);
			
		URL url=this.getClass().getResource("/default.png");
		try {
			img=ImageIO.read(url);
			System.out.println(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 140,140,this)	;	
				}
		};
		can.setPreferredSize(new Dimension(150, 150));
		
		bt_regist= new JButton("���");
		group= new CheckboxGroup();
		ch_table= new Checkbox();
		ch_grid= new Checkbox();
		//���� ���� �ø���
		chooser=new JFileChooser("C:/java_workspace2/dbproject2/res");
		//���̽� ������Ʈ�� ũ�� �� ����
		ch_top.setPreferredSize(new Dimension(130, 45));
		ch_sub.setPreferredSize(new Dimension(130, 45));
		
		ch_top.add("");
		ch_sub.add("");
		p_west.setLayout(new FlowLayout());
		p_west.setPreferredSize(new Dimension(150, 600));
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_price);
		p_west.add(can);
		p_west.add(bt_regist);
		p_west.setBackground(Color.YELLOW);
		
		
		p_north.add(ch_table);
		ch_table.setLabel("���̺�");
		p_north.add(ch_grid);
		init();
		ch_top.addItemListener(this);
		can.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
				openFile();
			}
		});
		
		ch_grid.setLabel("�׸���");
		
		p_center.add(p_north);
		p_center.add(p_content);
		//p_content.setBackground(Color.BLUE);
		
		add(p_west,BorderLayout.WEST);
		add(p_center,BorderLayout.CENTER);
		
		setVisible(true);
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init(){
		//���̽� ������Ʈ�� �ֻ��� ��� ���̱�!!!
		con=manager.getConnection();
		String sql="select *from topcategory";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println("�ǳ�??");
				ch_top.add(rs.getString("category_name"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void getSub(String v){
		//������ �̹� ä���� �������� �ִٸ� ,���� ��~~�����
		ch_sub.removeAll();
		StringBuffer sb=new StringBuffer();
		sb.append("select *from subcategory");
		sb.append(" where topcategory_id=(");
		sb.append(" select topcategory_id from");
		sb.append(" topcategory where category_name='"+v+"')");
		System.out.println(sb.toString());
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			while(rs.next()){
				ch_sub.add(rs.getString("category_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void itemStateChanged(ItemEvent e) {
      Choice ch=(Choice)e.getSource();
      getSub(ch.getSelectedItem());
	}
	public void openFile(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//������ �̹����� canvas�� �׸� ���̴�~~!!
			File file=chooser.getSelectedFile();
			
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		System.out.println("�� ������?");
		if(obj==img){
		}
	}
	public static void main(String[] args){
		new BookMain();
		
	}
}
