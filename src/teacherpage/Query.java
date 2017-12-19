package teacherpage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*	 query查询组件   */
class Query extends JPanel{
	JLabel label;
	JTextField text;
	JButton button;
	Query() {
		init();//样式处理
		add(label);
		add(text);
		add(button);
		validate();
		setVisible(true);
	}
	void init(){
		setLayout(null);
		label = new JLabel("教学班编号");
		text = new JTextField();
		button= new JButton("查询");
		label.setBounds(10,0,100,60);
		label.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 16));
		text.setText("请输入课程编号");
		text.setBounds(130,0,500,60);
		text.setFont(new Font("宋体", Font.BOLD, 21));
		button.setBounds(710,0,200,60);
		button.setBackground(Color.cyan);
		button.setFont(new Font("宋体", Font.BOLD, 16));
	}
}