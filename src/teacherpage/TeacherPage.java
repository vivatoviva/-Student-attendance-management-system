package teacherpage;

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
/* 
 * 功能：教师管理页面
 * 步骤：实现教师管理页面
 * author：**
 */ 
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

public class TeacherPage extends JPanel implements ActionListener{
    private static TeacherPage instance=null;
	private Query query;//查询组件
	private Check check;//选择组件
	private Friend friend;//学生信息展示组件
	private static final long serialVersionUID = 1L;
	
	private TeacherPage(){
		
		setLayout(null);
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
		check.setBounds(10, 80, 930,900);
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
			System.out.println(query.text.getText());
			String str = query.text.getText();
			
			TableModel.data = new String[][] {{ "2016210978", "李根1", "正常" },{ "20162109789", "杨东山", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" }};        
			if(str.equals("03011601")) {
				TableModel.data = new String[][] { { "2016210978", "李根2", "正常" },{ "20162109789", "杨东山", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" },{ "1", "盖伦", "正常" }};        
				table.updateUI();
				table.repaint();
				table.revalidate(); 
				table.validate();
				table.setModel(check.item.tableModel);
				check.item.sp.getViewport().add(table, null);
				check.item.sp.revalidate();
				check.item.tableModel.fireTableStructureChanged();// JTable刷新结构
				check.item.tableModel.fireTableDataChanged();// 刷新JTable数据 
				check.item.setUpSportColumn(table, table.getColumnModel().getColumn(2));
				check.item.makeFace();
				check.item.setVisible(false);
				check.item.validate();
				check.item.setVisible(true);
			}
			check.setVisible(true);
		}else if(e.getSource()==check.title.button) {
			//保存按钮点击执行操作
			System.out.println("保存操作");
			int count=table.getSelectedRow();
			for(int i=0;i<table.getRowCount();i++){
				System.out.println(table.getValueAt(i, 0).toString()+table.getValueAt(i, 2).toString());
			}
		}
	}
}

