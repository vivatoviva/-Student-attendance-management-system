package helllopage;

/* 
 * ���ܣ���ӭҳ��
 * ���裺ʵ�ֻ�ӭҳ��
 * author��**
 */  

import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * û��Ҫ���ľ���һ�����JPanel
 * ��ӭҳ�����ʵ�ִ���(ʹ�õ���ģʽ)
 */
public class HelloPanel extends JPanel{
    private static HelloPanel instance=null;
	private JLabel label;
	private static final long serialVersionUID = 1L;
	
	private HelloPanel(){
		label = new JLabel("��ӭ����ѧ�����ڹ���ϵͳ�����Ϸ�ѡ������Ҫ�ķ���");
		label.setBounds(0,0,1400,800);
		add(label,JLabel.CENTER);
		setOpaque(false);
		validate();
	}
	
	public static HelloPanel getInstance(){
        if(instance==null){
            instance=new HelloPanel();
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

