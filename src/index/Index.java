/* 
 * ���ܣ�ҳ����
 * ���裺ʵ��ҳ���������
 * author�����
 */  

package index;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import adminpage.AdminPage;
import helllopage.HelloPanel;
import studentpage.StudentPanel;
import teacherpage.TeacherPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Index {
	public static void main(String[] args) {
		HomePage homepage = new HomePage();
		Anima.home = homepage;
	}
}
class HomePage extends JFrame{

	JPanel panel;//���в������
	JLabel title;
	JButton studentButton,teacherButton,adminButton;
	Buttonaction buttonAaction;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		setBounds(200,100,1400,800);
		setTitle("ѧ������ϵͳ");
		setResizable(false);
		panelinit();
		add(panel);
		hellopage();
		studentpage();
		teacherpage();
		adminpage();
		validate();
		setVisible(true);
	}
	private void panelinit() {
		panel = new JPanel();
		title=new JLabel("ѧ�����ڹ���ϵͳ",JLabel.CENTER);
		title.setOpaque(true);//���ÿռ䲻͸��
		title.setBounds(0,0,1400,60);
		title.setBackground(Color.cyan);
		title.setForeground(Color.BLACK);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		
		studentButton = new JButton("ѧ������");
		teacherButton = new JButton("��ʦ����");
		adminButton = new JButton("�������");
		
		studentButton.setBounds(0,60,462,30);
		teacherButton.setBounds(462,60,462,30);
		adminButton.setBounds(924,60,470,30);
		
		Icon studentIcon = new ImageIcon("ѧ��.png");
		Icon teacherIcon = new ImageIcon("��ʦ.png");
		Icon adminIcon = new ImageIcon("����.png");
		
		buttonAaction = new Buttonaction();
		studentButton.addActionListener(buttonAaction);
		teacherButton.addActionListener(buttonAaction);
		adminButton.addActionListener(buttonAaction);
		
		panel.setLayout(null);
		panel.add(title);
		panel.add(studentButton);
		panel.add(teacherButton);
		panel.add(adminButton);
		panel.validate();
		panel.setVisible(true);
	}
	void hellopage() {
		HelloPanel hello = HelloPanel.getInstance();
		hello.setBounds(0,120,1400,800);
		panel.add(hello);
		hello.setOpaque(true);
		hello.setBackground(Color.cyan);
		hello.open();
	}
	void studentpage() {
		StudentPanel student = StudentPanel.getInstance();
		student.setBounds(0,120,1400,800);
		student.setOpaque(true);
		//student.setBackground(Color.cyan);
		panel.add(student);
		student.close();
	}
	void teacherpage() {
		TeacherPage teacher = TeacherPage.getInstance();
		teacher.setBounds(0,120,1400,800);
		teacher.setOpaque(true);
		panel.add(teacher);
		teacher.close();
	}
	void adminpage() {
		AdminPage admin = AdminPage.getInstance();
		admin.setBounds(0,120,1400,800);
		admin.setOpaque(true);
		panel.add(admin);
		admin.close();
	}
}

/*��ť������*/
class Buttonaction implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			String str = e.getActionCommand();
			HelloPanel hello = HelloPanel.getInstance();
			StudentPanel student = StudentPanel.getInstance();
			TeacherPage teacher = TeacherPage.getInstance();
			AdminPage admin = AdminPage.getInstance();
			if(str.equals("ѧ������")) {
				//hello.close();
				openThread();
				teacher.close();
				student.open();
				admin.close();
			}else if (str.equals("��ʦ����")) {
				//hello.close();
				hello.setAlignmentY(750);
				openThread();
				teacher.open();
				student.close();
				admin.close();
			}else {
				//hello.close();
				openThread();
				teacher.close();
				student.close();
				admin.open();
			}		
	}
	void openThread() {
		Anima anima = new Anima();
		Thread thread = new Thread(anima);
		thread.start();
	}
}
class Anima implements Runnable{
	HelloPanel hello = HelloPanel.getInstance();
	static HomePage home;
	public void run() {
		int i = 1;
		while (hello.getY()<730) {
			i++;
			hello.setBounds(0,120+i,1400,800);
			home.validate();
		}
	}	
}



 