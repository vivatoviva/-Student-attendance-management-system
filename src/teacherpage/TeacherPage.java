package teacherpage;
/* 
 * 功能：教师管理页面
 * 步骤：实现教师管理页面
 * author：李根
 */ 
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import DB.Update;
import DB.insearch1;

public class TeacherPage extends JPanel implements ActionListener{
    private static TeacherPage instance=null;
	private Query query;//查询组件
	private Check check;//选择组件
	private Friend friend;//学生信息展示组件
	private static final long serialVersionUID = 1L;
	
	private TeacherPage(){
		setLayout(null);
		setOpaque(false);
		query  = new Query();
		query.setBounds(0,0,1400,60);
		query.button.addActionListener(this);
		add(query);
		
		friend = new Friend();
		friend.setBounds(1000,150,300,400);
		friend.setBackground(Color.CYAN);
		TableListen.getInstance().friend=friend;
		add(friend);
		
		check = new Check();
		check.setBounds(10, 80, 930,500);
		check.setVisible(false);
		check.title.button.addActionListener(this);
		add(check);
		
		validate();
		
	}
	
	public static TeacherPage getInstance(){
        if(instance==null){
            instance=new TeacherPage();
        }
        return instance;
    }
	public void open(){
		setVisible(true);	
	}
	public void close() {
		setVisible(false);
	}
	//监视器具体实现
	public void actionPerformed(ActionEvent e) {
		//查询按钮点击效果
		JTable table = check.item.table;//check中的表格
		if(e.getSource()==query.button){
			String str = query.text.getText();
			int no = Integer.parseInt(str);
			insearch1 db=new insearch1();
			TableModel.data = db.get(str);
			table.updateUI();
			check.setVisible(true);
		}else if(e.getSource()==check.title.button) {
			//保存按钮点击执行操作
			int count=table.getSelectedRow();
			int rows = table.getRowCount();
			Update db = new Update();
			for(int i=0;i<table.getRowCount();i++){
				db.updateKaoqing(table.getValueAt(i, 0).toString(), query.text.getText(), table.getValueAt(i, 2).toString());
			}			
		}
	}
}

