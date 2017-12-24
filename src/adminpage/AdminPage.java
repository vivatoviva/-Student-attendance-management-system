package adminpage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.CollationElementIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import DB.Update;
import DB.insearch2;
import DB.insearch3;

public class AdminPage extends JPanel{
	Studentpanel studentpanel;//学生信息展示
	Studentupdate studentupdate;//修改信息组件
	static AdminPage instance;
	public AdminPage() {
		setLayout(null);
		studentpanel = new Studentpanel();
		studentpanel.setBounds(10,100,690,500);
		add(studentpanel);
		//studentpanel.add(button);
		studentupdate=new Studentupdate();
		studentupdate.setBounds(730,100,680,500);
		TableListen.studentupdate = studentupdate;
		add(studentupdate);		
	}
	public void close() {
		setVisible(false);
	}
	public void open() {
		setVisible(true);
	}
	public static AdminPage getInstance() {
		if(instance==null) {
			instance = new AdminPage();
		}
		return instance;
	}
}
class Studentpanel extends JPanel{
	JTable table;
	TableModel tableModel;
	public TableListen listen;
	public Studentpanel() {
		setLayout(new GridLayout(0,1));	
		setBackground(Color.blue);
		table=new JTable();
		tableModel = new TableModel();
		table.setModel(tableModel);
		makeFace();
		listen=TableListen.getInstance();//得到实例
		listen.setTable(table);
		table.addMouseListener(listen);
		add(new JScrollPane(table));
		validate();
	}
    private void makeFace() { 
        table.setRowHeight(25);  
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {  
            public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {
            	if (row % 2 == 0) {  
	                   setBackground(new Color(203, 203, 203));
	               } else {  
	                   setBackground(Color.WHITE); 
	                } 
            	return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);  
            }  
        };  
        for (int i = 0; i < table.getColumnCount(); i++) {  
            table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);  
        }  
    }
	
}
class Studentupdate extends JPanel{
	JButton button;
	JLabel label,label2,label3;
	JTextField textField,textField2,textField3;
	public Studentupdate() {
		setLayout(null);
		setBackground(Color.white);
		label=new JLabel("姓名：");
		label2=new JLabel("学号：");
		label3=new JLabel("班级：");
		label.setBounds(100,90,100,50);
		label2.setBounds(100,150,100,50);
		label3.setBounds(100,210,100,50);
		textField=new JTextField(20);//姓名
		textField2=new JTextField(20);//学号
		textField3=new JTextField(20);//班级
		textField.setBounds(200,90,200, 50);
		textField2.setBounds(200,150,200, 50);
		textField3.setBounds(200,210,200, 50);
		button=new JButton("保存");
		button.setBounds(200, 270, 200, 50);
		button.addActionListener(new ActionListener() {//按钮监听事件，将修改数据传给数据库
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Update db = new Update();
				db.updateMessage(textField.getText(),textField2.getText(),textField3.getText());	
			}
		});
		add(label);add(textField);
		add(label2);add(textField2);
		label2.setVisible(false);
		textField2.setVisible(false);
		add(label3);add(textField3);
		add(button);
	}
	void updata(String no,String name,String grade) {
		textField.setText(name);
		textField2.setText(no);
		textField3.setText(grade);
		
		validate();
	}
}
class TableListen implements MouseListener{
	JTable table;
	private static TableListen instance;
	static Studentupdate studentupdate;
	public void mouseClicked(java.awt.event.MouseEvent e) {
		Component table = e.getComponent();
		int count = e.getClickCount();
		if(count>=2) {
			int a = ((JTable) table).getSelectedRow();
			String studentno = ((JTable) table).getValueAt(a,0).toString();
			String studentname =  ((JTable) table).getValueAt(a,1).toString();
			String studentclass=((JTable) table).getValueAt(a,2).toString();
			System.out.println(studentno);
			insearch3 db = new insearch3();
			studentupdate.updata(studentno, studentname,db.get(studentno) );
			//请求数据
		}
	}
	public static TableListen getInstance() {
		if(instance==null) {
			instance = new TableListen();
			return instance;
		}
		return instance;
	}
	void setTable(JTable table) {
		this.table = table;
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
class TableModel extends AbstractTableModel {
    private boolean DEBUG = false;
    //请求数据
    insearch2 db = new insearch2();
    String columnNames[] = {"学号","姓名","班级","总考勤次数","总请假次数","其他情况"};
	String data[][] = db.get();
    TableModel(){
    	System.out.println(data);
    }
    public int getRowCount() {
        return data.length;
    }
 
    // 返回一共有多少列
    public int getColumnCount() {
        return columnNames.length;
    }
 
    // 获取每一列的名称
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
 
    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // 每一个单元格里的值
    public Object getValueAt(int rowIndex, int columnIndex) {
    		return data[rowIndex][columnIndex]; 
    }
    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = (String) value;
        fireTableCellUpdated(row, col);
    }
    
}
