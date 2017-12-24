package teacherpage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/*检索这一块*/
public class Check extends JPanel{
	CheckTitle title;//操作的头部
	CheckItem item;//操作的选择项
	public Check() {
		init();//样式
		add(title);
		add(item);
		validate();
		setVisible(true);
	}
	void  init() {
		setLayout(null);
		title = new CheckTitle();
		title.setBounds(0,0,900,30);
		item = new CheckItem();
		item.setBounds(0, 50, 900, 450);
	}
}
class CheckTitle extends JPanel{
	JLabel timelabel;
	JButton button;
	public CheckTitle() {	
		init();
		add(timelabel);
		/* 占位 */
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(button);
	}
	
	private void  init(){
		setLayout(new GridLayout(0, 7));
		Date date=new Date(System.currentTimeMillis());
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");;
		String time=format.format(date);
		timelabel = new JLabel(time);
		button = new JButton("保存");
	}
}
class CheckItem extends JPanel{
	TableModel tableModel;//数据模型
	JTable table;//表格
	JScrollPane sp;//滚动窗口
	public TableListen listen;//table的监听器
	public CheckItem() {
		tableModel = new TableModel();
		table = new JTable(tableModel);
		listen = TableListen.getInstance();
		listen.setTable(table);
		table.addMouseListener(listen);
		sp = new JScrollPane(table);
		setLayout(new GridLayout(0, 1));
		setPreferredSize (new Dimension (600,400));
		setUpSportColumn(table, table.getColumnModel().getColumn(2));
		makeFace();
		add(sp);
	}
	/* 设置表格模型 */
    public void setUpSportColumn(JTable table,TableColumn Column) {
    	/* 设置几个可选项目 */
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("正常");
        comboBox.addItem("旷课");
        comboBox.addItem("迟到");
        comboBox.addItem("早退");
        comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int columns = table.getSelectedColumn();
				int rows = table.getSelectedRow();
				String staus = ((JComboBox) e.getSource()).getSelectedItem().toString();
				makeFace();
			}
		});
        Column.setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Column.setCellRenderer(renderer);
    }
    /* 表格样式进行修改 */
    private void makeFace() { 
        table.setRowHeight(25);  
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {  
            public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {
            	if(table.getValueAt(row, 2).equals("迟到")) {
           		 setBackground(new Color(250,235,215));
	           	}else if(table.getValueAt(row, 2).equals("旷课")){
	           		 setBackground(new Color(255,127,80));
	           	}else if(table.getValueAt(row, 2).equals("早退")) {
	           		 setBackground(new Color(30,144,255));
	           	}else {
	           		setBackground(new Color(202,255,112));
	           	} 
            	return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);  
            }  
        };  
        for (int i = 0; i < table.getColumnCount(); i++) {  
            table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);  
        }  
    }  
}
/* 表格数据模型 */
class TableModel extends AbstractTableModel {
    private boolean DEBUG = false;
    static String[] columnNames = new String[] { "学号", "姓名", "考勤" };
    static String[][] data =  new String[][] { { "2016210978", "李根2", "正常" }};
    // 返回一共有多少行
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
    	if(columnIndex<2) {
    		return false;
    	}
        return true;
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



