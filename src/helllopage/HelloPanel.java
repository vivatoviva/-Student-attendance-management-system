package helllopage;

/* 
 * 功能：欢迎页面
 * 步骤：实现欢迎页面
 * author：**
 */  

import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * 没人要做的就是一个面板JPanel
 * 欢迎页面具体实现代码(使用单例模式)
 */
public class HelloPanel extends JPanel{
    private static HelloPanel instance=null;
	private JLabel label;
	private static final long serialVersionUID = 1L;
	
	private HelloPanel(){
		label = new JLabel("欢迎来到学生考勤管理系统，请上方选择你需要的服务！");
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

