package adminpage;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class AdminPage extends JPanel{
    private static AdminPage instance=null;
	private JLabel label;
	private static final long serialVersionUID = 1L;
	
	private AdminPage(){
		label = new JLabel("欢迎来到admin服务");
		label.setBounds(0,0,1400,800);
		add(label,JLabel.CENTER);
		validate();
	}
	
	public static AdminPage getInstance(){
        if(instance==null){
            instance=new AdminPage();
        }
        return instance;
    }
	public void open(){
		setVisible(true);	
	}
	public void close() {
		setVisible(false);
		
	}
}