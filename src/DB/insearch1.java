package DB;
/*
 * ��ʦҳ����Ҫʹ�õĺ���
 */
import java.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class insearch1 {
	String studentNumber,classNumber;
	String data[][];
		private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC����
		private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //����Դ 
				Connection conn =null;             //����
		private ResultSet rs = null;//�����
		
		public insearch1(){
			//����JDBC-ODBC����
			try {
				Class.forName(strDBDriver );
			}
			//�����쳣
			catch(java.lang.ClassNotFoundException e){
				System.err.println("insearch1():" + e.getMessage());
			}	
		}

		public String[][] get(String classNumber){
			String strSql = null;
			
			ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
				strSql = "select ѧ��.ѧ��,�༶,���� from �γ�,dbo.ѧ��,���ڱ�\r\n" + 
				"where ѧ��.ѧ�� =���ڱ�.ѧ�� and ���ڱ�.�γ̺� =�γ�.�γ̺� And ���ڱ�.�γ̺�='"+classNumber+"'";
				rs = stmt.executeQuery(strSql);;
				while(rs.next()) {
					list.add(rs.getString("ѧ��"));
					list.add(rs.getString("����"));
					list.add("����");
				}
			 
			data=new String[list.size()/3][3];
			
			for(int a=0;a<list.size()/3;a++)
				
				for(int i=0;i<3;i++)
					data[a][i]=list.get(a*3+i);
				stmt.close();
				conn.close();
				
			}
		
			//�����쳣
			catch(SQLException e){
			
				System.err.println("insearch():"+ e.getMessage());
			}
			return data;
			
		}
		}

