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

/*������һ��*/
public class Check extends JPanel{
	CheckTitle title;//������ͷ��
	CheckItem item;//������ѡ����
	public Check() {
		init();//��ʽ
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
		/* ռλ */
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
		button = new JButton("����");
	}
}
class CheckItem extends JPanel{
	TableModel tableModel;//����ģ��
	JTable table;//���
	JScrollPane sp;//��������
	public TableListen listen;//table�ļ�����
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
	/* ���ñ��ģ�� */
    public void setUpSportColumn(JTable table,TableColumn Column) {
    	/* ���ü�����ѡ��Ŀ */
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("����");
        comboBox.addItem("����");
        comboBox.addItem("�ٵ�");
        comboBox.addItem("����");
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
    /* �����ʽ�����޸� */
    private void makeFace() { 
        table.setRowHeight(25);  
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {  
            public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {
            	if(table.getValueAt(row, 2).equals("�ٵ�")) {
           		 setBackground(new Color(250,235,215));
	           	}else if(table.getValueAt(row, 2).equals("����")){
	           		 setBackground(new Color(255,127,80));
	           	}else if(table.getValueAt(row, 2).equals("����")) {
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
/* �������ģ�� */
class TableModel extends AbstractTableModel {
    private boolean DEBUG = false;
    static String[] columnNames = new String[] { "ѧ��", "����", "����" };
    static String[][] data =  new String[][] { { "2016210978", "���2", "����" }};
    // ����һ���ж�����
    TableModel(){
    	System.out.println(data);
    }
    public int getRowCount() {
        return data.length;
    }
 
    // ����һ���ж�����
    public int getColumnCount() {
        return columnNames.length;
    }
 
    // ��ȡÿһ�е�����
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
 
    // ��Ԫ���Ƿ�����޸�
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	if(columnIndex<2) {
    		return false;
    	}
        return true;
    }
 
    // ÿһ����Ԫ�����ֵ
    public Object getValueAt(int rowIndex, int columnIndex) {
    		return data[rowIndex][columnIndex]; 
    }
    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = (String) value;
        fireTableCellUpdated(row, col);
    }
}



