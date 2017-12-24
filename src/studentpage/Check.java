package studentpage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;



public class Check  extends JPanel{
	JTable table;
	String []title = {"姓名","课程名","正常","请假","迟到","早退","旷课"};
	public Check(String data[][]) {
		table = new JTable(data,title);
		setLayout(new GridLayout(0, 1));
		setPreferredSize (new Dimension (600,400));
		setPreferredSize (new Dimension (600,400));
		makeFace();
		table.setEnabled(false);
		add(new JScrollPane(table));
		validate();
	}
	public void update(String [][]data) {
		table = new JTable(data,title);
		add(table);
		validate();
		setVisible(true);
	}
    /* 表格样式进行修改 */
    public void makeFace() {  
        table.setRowHeight(25);  
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {  
            public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {
            	if (row % 2 == 0) {  
                    setBackground(new Color(203, 203, 203));
                } else {  
                    setBackground(Color.WHITE);  
                }  
                return super.getTableCellRendererComponent(table, value,  
                        isSelected, hasFocus, row, column);  
            }  
        };  
        for (int i = 0; i < table.getColumnCount(); i++) {  
            table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);  
        }  
    } 
}