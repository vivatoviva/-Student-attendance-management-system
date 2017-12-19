/* 
 * ���ܣ�ѧ������ҳ��
 * ���裺ʵ��ѧ����ӭҳ��
 * author��**
 */ 
package studentpage;
 
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StudentPanel extends JPanel{
    private static StudentPanel instance=null;
	private JLabel label;
	private static final long serialVersionUID = 1L;
	
	private StudentPanel(){
		label = new JLabel("��ӭ����ѧ������");
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