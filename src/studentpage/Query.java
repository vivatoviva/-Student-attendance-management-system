package studentpage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*	 query��ѯ���   */
class Query extends JPanel{
	JLabel label;
	JTextField text;
	JButton button;
	Query() {
		init();//��ʽ����
		add(label);
		add(text);
		add(button);
		validate();
		setVisible(true);
	}
	void init(){
		setLayout(null);
		label = new JLabel("ѧ��ѧ�ţ�");
		text = new JTextField();
		button= new JButton("��ѯ");
		label.setBounds(10,0,130,60);
		label.setFont(new Font("΢���ź�", Font.CENTER_BASELINE, 16));
		text.setText("������ѧ��ѧ��");
		text.setBounds(150,0,500,60);
		text.setFont(new Font("����", Font.BOLD, 21));
		button.setBounds(710,0,200,60);
		button.setBackground(Color.cyan);
		button.setFont(new Font("����", Font.BOLD, 16));
	}
}