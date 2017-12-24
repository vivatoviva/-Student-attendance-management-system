package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Search {
	String studentNumber,classNumber;
	String data[][];
		private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC����
		private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //����Դ 
		Connection conn =null;             //����
		private ResultSet rs = null;//�����
		
		public Search(){
			try {
				Class.forName(strDBDriver );
			}
			catch(java.lang.ClassNotFoundException e){
				System.err.println("insearch():" + e.getMessage());
			}	
		}

		public String[][] findstudentNumber(int studentNumber){
			String strSql = null;
			ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
		strSql = "Select ����,�γ���,����,���,�ٵ�,����,����  from ѧ��,���ڱ�,�γ�  \r\n" + 
				"where ѧ��.ѧ�� =���ڱ�.ѧ�� and ���ڱ�.�γ̺� =�γ�.�γ̺� and ѧ��.ѧ�� =" + studentNumber;
				rs = stmt.executeQuery(strSql);
				System.out.println(rs.getRow());
				while(rs.next()) {
				
					System.out.println(rs.getRow());
					list.add(rs.getString("����"));
					list.add(rs.getString("�γ���"));
					list.add(rs.getInt("����")+"");
					list.add(rs.getInt("���")+"");
					list.add(rs.getInt("�ٵ�")+"");
					list.add(rs.getInt("����")+"");
					list.add(rs.getInt("����")+"");
					
					
				}
			for(int i=0;i<list.size();i++)
				System.out.print(list.get(i));
			 data=new String[list.size()/7][7];
			for(int a=0;a<list.size()/7;a++)
				
				for(int i=0;i<7;i++)
					data[a][i]=list.get(a*7+i);
				stmt.close();
				conn.close();	
			}
		
			//�����쳣
			catch(SQLException e){
				System.err.println("insearch():"+ e.getMessage());
			}
			return data;	
		}
		public String[][] findclassNumber(String classNumber){
			String strSql = null;
			
			ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
		strSql = "select �༶,���� from �γ�,dbo.ѧ��,���ڱ�\r\n" + 
				"where ѧ��.ѧ�� =���ڱ�.ѧ�� and ���ڱ�.�γ̺� =�γ�.�γ̺� And ���ڱ�.�γ̺�='"+classNumber+"'";
				rs = stmt.executeQuery(strSql);
				System.out.println(rs);
				System.out.println(rs.getRow());
				while(rs.next()) {
				
					//System.out.println(rs.getRow());
					list.add(rs.getString("�༶"));
					list.add(rs.getString("����"));
					System.out.println(rs.getString("�༶"));
					list.add("����");
				}
			for(int i=0;i<list.size();i++)
				System.out.print(list.get(i));
			 
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
		public String[][] getMessage(){
			String strSql = null;
			
			ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
		strSql = "select ����,sum(����)as '1',sum(���)as '2',sum(�ٵ�)as '3',sum(����)as '4',sum(����)as '5'\r\n" + 
				"from ѧ��,���ڱ�,�γ� where ѧ��.ѧ�� =���ڱ�.ѧ�� and ���ڱ�.�γ̺� =�γ�.�γ̺� group by ѧ��.ѧ��,ѧ��.����";
				rs = stmt.executeQuery(strSql);
				System.out.println(rs);
				System.out.println(rs.getRow());
				while(rs.next()) {
				
					//System.out.println(rs.getRow());
					list.add(rs.getString("����"));
					list.add(rs.getInt("1")+"");
					list.add(rs.getInt("2")+"");
					list.add(rs.getInt("3")+"");
					list.add(rs.getInt("4")+"");
					list.add(rs.getInt("5")+"");
				
					
				
				}
			for(int i=0;i<list.size();i++)
				System.out.print(list.get(i));
			 
			data=new String[list.size()/6][6];
			
			for(int a=0;a<list.size()/6;a++)
				
				for(int i=0;i<6;i++)
					data[a][i]=list.get(a*6+i);
				stmt.close();
				conn.close();
				
			}
		
			//�����쳣
			catch(SQLException e){
			
				System.err.println("insearch2():"+ e.getMessage());
			}
			return data;
			
		}
		
		public static void main(String []args) {
			Search n1=new Search();
		    String daata[][] = n1.findstudentNumber(2016210991);
			String daata1[][]=n1.findclassNumber("A01");
			String daata2[][]=n1.getMessage();
			}
		}
