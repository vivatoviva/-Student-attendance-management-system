import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.table.TableColumn;

public class Test
{
 public static void main (String[] args)
 {
  final Object[] columnNames = {"����", "�Ա�", "��ͥ��ַ",//���������final����
   "�绰����", "����", "����", "����", "����״��","����״��"};
  Object[][] rowData = {
     {"ddd", "��", "�����Ͼ�", "1378313210", "03/24/1985", "ѧ��", "������", "δ��", "û"},
     {"eee", "Ů", "�����Ͼ�", "13645181705", "xx/xx/1985", "�ҽ�", "δ֪", "δ��", "����û"},
     {"fff", "��", "�����Ͼ�", "13585331486", "12/08/1985", "��������Ա", "��ȷ��", "δ��", "��"},
     {"ggg", "Ů", "�����Ͼ�", "81513779", "xx/xx/1986", "���ݷ���Ա", "ȷ����δ֪", "δ��", "��"},
     {"hhh", "��", "�����Ͼ�", "13651545936", "xx/xx/1985", "ѧ��", "������", "δ��", "�����η��ֺ�û��"},
     {"ddd", "��", "�����Ͼ�", "1378313210", "03/24/1985", "ѧ��", "������", "δ��", "û"},
     {"eee", "Ů", "�����Ͼ�", "13645181705", "xx/xx/1985", "�ҽ�", "δ֪", "δ��", "����û"},
     {"fff", "��", "�����Ͼ�", "13585331486", "12/08/1985", "��������Ա", "��ȷ��", "δ��", "��"},
     {"ggg", "Ů", "�����Ͼ�", "81513779", "xx/xx/1986", "���ݷ���Ա", "ȷ����δ֪", "δ��", "��"},
     {"hhh", "��", "�����Ͼ�", "13651545936", "xx/xx/1985", "ѧ��", "������", "δ��", "�����η��ֺ�û��"},
     {"ddd", "��", "�����Ͼ�", "1378313210", "03/24/1985", "ѧ��", "������", "δ��", "û"},
     {"eee", "Ů", "�����Ͼ�", "13645181705", "xx/xx/1985", "�ҽ�", "δ֪", "δ��", "����û"},
     {"fff", "��", "�����Ͼ�", "13585331486", "12/08/1985", "��������Ա", "��ȷ��", "δ��", "��"},
     {"ggg", "Ů", "�����Ͼ�", "81513779", "xx/xx/1986", "���ݷ���Ա", "ȷ����δ֪", "δ��", "��"},
     {"hhh", "��", "�����Ͼ�", "13651545936", "xx/xx/1985", "ѧ��", "������", "δ��", "�����η��ֺ�û��"},
     {"ddd", "��", "�����Ͼ�", "1378313210", "03/24/1985", "ѧ��", "������", "δ��", "û"},
     {"eee", "Ů", "�����Ͼ�", "13645181705", "xx/xx/1985", "�ҽ�", "δ֪", "δ��", "����û"},
     {"fff", "��", "�����Ͼ�", "13585331486", "12/08/1985", "��������Ա", "��ȷ��", "δ��", "��"},
     {"ggg", "Ů", "�����Ͼ�", "81513779", "xx/xx/1986", "���ݷ���Ա", "ȷ����δ֪", "δ��", "��"},
     {"hhh", "��", "�����Ͼ�", "13651545936", "xx/xx/1985", "ѧ��", "������", "δ��", "�����η��ֺ�û��"}
 
    };
  
  
  JTable friends = new JTable (rowData, columnNames);
  friends.setPreferredScrollableViewportSize(new Dimension(600, 100));//���ñ��Ĵ�С
  friends.setRowHeight (30);//����ÿ�еĸ߶�Ϊ20
  friends.setRowHeight (0, 20);//���õ�1�еĸ߶�Ϊ15
  friends.setRowMargin (5);//�����������е�Ԫ��ľ���
  friends.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse
  friends.setSelectionBackground (Color.white);//������ѡ���еı���ɫ
  friends.setSelectionForeground (Color.red);//������ѡ���е�ǰ��ɫ
  friends.setGridColor (Color.black);//���������ߵ���ɫ
  friends.selectAll ();//ѡ��������
  friends.setRowSelectionInterval (0,2);//���ó�ʼ��ѡ����,������1��3�ж�����ѡ��״̬
  friends.clearSelection ();//ȡ��ѡ��
  friends.setDragEnabled (false);//�������
  friends.setShowGrid (false);//�Ƿ���ʾ������
  friends.setShowHorizontalLines (false);//�Ƿ���ʾˮƽ��������
  friends.setShowVerticalLines (true);//�Ƿ���ʾ��ֱ��������
  friends.setValueAt ("tt", 0, 0);//����ĳ����Ԫ���ֵ,���ֵ��һ������
  friends.doLayout ();
  friends.setBackground (Color.lightGray);
  
  
  JScrollPane pane = new JScrollPane (friends);
  JPanel panel = new JPanel (new GridLayout (0, 1));
  panel.setPreferredSize (new Dimension (600,400));
  panel.setBackground (Color.black);
  panel.add (pane);
  
  JFrame frame = new JFrame ("JTableDemo");
  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  
  frame.setContentPane (panel);
  
  frame.pack();
  frame.show();
  
  
 }
}