package DB;

import java.sql.*;


public class DB {
	 //�����������ݿ�����
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=kaoqin";
    private static final String USER="sa";
    private static final String PASSWORD="123";
    
    private static Connection conn=null;
   
    //��̬����飨�������������������ݿ���뾲̬���У�
    static{
        try {
            //1.������������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.������ݿ������
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //�����ṩһ����������ȡ���ݿ�����
    public static Connection getConnection(){
        return conn;
    }
    //��������
    public static void main(String[] args) throws Exception{
        
        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
        Statement stmt = conn.createStatement();
        ResultSet rs =  stmt.executeQuery("select * from ѧ��");//ִ�в�ѯ���ݿ��SQL���   ������һ���������ResultSet������


    }
}

