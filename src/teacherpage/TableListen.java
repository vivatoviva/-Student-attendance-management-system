package teacherpage;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseListener;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JTable;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class TableListen implements MouseListener{
	JTable table;
	Friend friend;
	private static TableListen instance;
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		Component table = e.getComponent();
		int count = e.getClickCount();
		if(count>=2) {
			int a = ((JTable) table).getSelectedRow();
			String studentno = ((JTable) table).getValueAt(a,0).toString();
			String studentname =  ((JTable) table).getValueAt(a,1).toString();
			
			friend.updata(studentname, studentno, "45465465");
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
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
