package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Update {
	String studentNumber,classNumber,zhuangtai,classnum,name;
	String data[][];
		private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC����
		private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //����Դ 
		Connection conn =null;             //����
		private ResultSet rs = null;//�����
		public Update(){
			//����JDBC-ODBC����
			try {
				Class.forName(strDBDriver );
			}
			//�����쳣
			catch(java.lang.ClassNotFoundException e){
				System.err.println("insearch():" + e.getMessage());
			}	
		}
		//teacherpageʹ��
		public void updateKaoqing(String stunumber,String classnumber,String zhuangtai){ 
			String strSql = null;
			//ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
				strSql =  " update ���ڱ� set "+zhuangtai+"="+zhuangtai+"+1 where ѧ��='"+stunumber +"' and �γ̺�= '"+classnumber+"'";
			 	stmt.executeUpdate(strSql);
			}
			catch(SQLException e){
				System.err.println("Update():"+ e.getMessage());
			}
		}
		//adminpageʹ��
		public void updateMessage(String stunumber,String name,String classnum){ 
			String strSql = null;
			//ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
				strSql =  "  update ѧ��\r\n" + 
					" set ����='"+name+"' ,  �༶='"+classnum+"'\r\n" + 
					" where ѧ��='"+stunumber+"'";
			 stmt.executeUpdate(strSql);
			}
			catch(SQLException e){
				
				System.err.println("Update():"+ e.getMessage());
			}
		}
}
