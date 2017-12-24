/* 
 * 功能：页面框架
 * 步骤：实现页面的整体框架
 * author：李根
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

	JPanel panel;//所有操作面板
	JLabel title;
	JButton studentButton,teacherButton,adminButton;
	Buttonaction buttonAaction;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		setBounds(200,100,1400,800);
		setTitle("学生管理系统");
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
		title=new JLabel("学生考勤管理系统",JLabel.CENTER);
		title.setOpaque(true);//设置空间不透明
		title.setBounds(0,0,1400,60);
		title.setBackground(Color.cyan);
		title.setForeground(Color.BLACK);
		title.setFont(new java.awt.Font("Dialog", 1, 20));
		
		studentButton = new JButton("学生服务");
		teacherButton = new JButton("教师服务");
		adminButton = new JButton("管理服务");
		
		studentButton.setBounds(0,60,462,30);
		teacherButton.setBounds(462,60,462,30);
		adminButton.setBounds(924,60,470,30);
		
		Icon studentIcon = new ImageIcon("学生.png");
		Icon teacherIcon = new ImageIcon("教师.png");
		Icon adminIcon = new ImageIcon("管理.png");
		
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

/*按钮监听器*/
class Buttonaction implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			String str = e.getActionCommand();
			HelloPanel hello = HelloPanel.getInstance();
			StudentPanel student = StudentPanel.getInstance();
			TeacherPage teacher = TeacherPage.getInstance();
			AdminPage admin = AdminPage.getInstance();
			if(str.equals("学生服务")) {
				//hello.close();
				openThread();
				teacher.close();
				student.open();
				admin.close();
			}else if (str.equals("教师服务")) {
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



 