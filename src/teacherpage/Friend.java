package teacherpage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Friend extends JPanel{
	JLabel namelabel,nolabel,gradelabel;
	Friend(){
		init();
		validate();
		setVisible(false);
	}
	void init() {
		setLayout(null);
		Font font = new Font("宋体", Font.BOLD, 20);
		namelabel = new JLabel("姓名:李根");
		nolabel = new JLabel("学号:2016210978");
		gradelabel = new JLabel("班级：03011601");
		
		add(namelabel);
		add(nolabel);
		add(gradelabel);
		namelabel.setFont(font);
		namelabel.setBounds(50,50,250,50);

		nolabel.setFont(font);
		nolabel.setBounds(50,105,250,50);

		gradelabel.setFont(font);
		gradelabel.setBounds(50,155,250,50);
	}
	void updata(String name,String no,String grad) {
		namelabel.setText("姓名： "+name);
		nolabel.setText("学号："+no);
		gradelabel.setText("班级："+grad);
		validate();
		setVisible(true);
		}
}
