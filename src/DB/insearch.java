package DB;
/*
 * ѧ��ҳ����Ҫʹ�õĺ���
 */
import java.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.standard.PrinterLocation;
import javax.xml.crypto.Data;

public class insearch {
	String studentNumber,classNumber;
	String data[][];
	private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC����
	private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //����Դ 
	Connection conn =null;             //����
	private ResultSet rs = null;//�����
	
	public insearch(){
		//����JDBC-ODBC����
		try {
			Class.forName(strDBDriver );
		}
		//�����쳣
		catch(java.lang.ClassNotFoundException e){
			System.err.println("insearch():" + e.getMessage());
		}	
	}

	public String[][] get(String studentNumber){
		String strSql = null;
		ArrayList<String> list =new ArrayList<String>();
		try{
			conn = DriverManager.getConnection(strDBUrl);
			Statement stmt = conn.createStatement();
	strSql = "Select ����,�γ���,����,���,�ٵ�,����,����  from ѧ��,���ڱ�,�γ�  \r\n" + 
			"where ѧ��.ѧ�� =���ڱ�.ѧ�� and ���ڱ�.�γ̺� =�γ�.�γ̺� and ѧ��.ѧ�� ='" + studentNumber+"'";
			rs = stmt.executeQuery(strSql);
			while(rs.next()) {		
				list.add(rs.getString("����"));
				list.add(rs.getString("�γ���"));
				list.add(rs.getInt("����")+"");
				list.add(rs.getInt("���")+"");
				list.add(rs.getInt("�ٵ�")+"");
				list.add(rs.getInt("����")+"");
				list.add(rs.getInt("����")+"");
			}
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
	}

