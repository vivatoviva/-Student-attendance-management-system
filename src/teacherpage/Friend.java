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
		Font font = new Font("����", Font.BOLD, 20);
		namelabel = new JLabel("����:���");
		nolabel = new JLabel("ѧ��:2016210978");
		gradelabel = new JLabel("�༶��03011601");
		
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
		namelabel.setText("������ "+name);
		nolabel.setText("ѧ�ţ�"+no);
		gradelabel.setText("�༶��"+grad);
		validate();
		setVisible(true);
		}
}
