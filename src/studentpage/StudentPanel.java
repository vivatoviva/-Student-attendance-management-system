/* 
 * 功能：学生服务页面
 * 步骤：实现学生欢迎页面
 * author：**
 */ 
package studentpage;
 
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StudentPanel extends JPanel{
    private static StudentPanel instance=null;
	private JLabel label;
	private static final long serialVersionUID = 1L;
	
	private StudentPanel(){
		label = new JLabel("欢迎来到学生服务");
		label.setBounds(0,0,1400,800);
		add(label,JLabel.CENTER);
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
}