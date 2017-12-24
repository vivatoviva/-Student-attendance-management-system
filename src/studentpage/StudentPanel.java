package studentpage;

/* 
 * ���ܣ���ʦ����ҳ��
 * ���裺ʵ�ֽ�ʦ����ҳ��
 * author����С��
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
import javax.xml.crypto.Data;

import DB.insearch;
import DB.insearch1;
import DB.insearch3;

public class StudentPanel extends JPanel implements ActionListener{
    private static StudentPanel instance=null;
	private static final long serialVersionUID = 1L;
	private Query query;//��ѯ���
	Friend friend;
	Check check;
	JScrollPane scrollPane;
	private StudentPanel(){
		setLayout(null);
		query  = new Query();
		query.setBounds(0,0,1400,60);
		query.button.addActionListener(this);
		add(query);
		
		friend = new Friend();
		friend.setBounds(1000,150,300,400);
		friend.setBackground(Color.CYAN);
		add(friend);
		validate();

		validate();
	}
	
	public static StudentPanel getInstance(){
        if(instance==null){
            instance=new StudentPanel();
        }
        return instance;
    }
	public void open(){
		setVisible(true);	
	}
	public void close() {
		setVisible(false);
	}
	//����������ʵ��
	public void actionPerformed(ActionEvent e) {
		insearch db = new insearch();
		insearch3 dbs = new insearch3();
		//��ѯ��ť���Ч��
		if(e.getSource() == query.button) {
			String data[][] = db.get(query.text.getText());
			if(check!=null)remove(check);//���ԭ���ؼ������¿ؼ�
			check=new Check(data);
			check.setBounds(10, 120, 930,460);
			add(check);
			friend.updata(query.text.getText(), query.text.getText(),dbs.get(query.text.getText()));//��������
			validate();
		}
	}
}

