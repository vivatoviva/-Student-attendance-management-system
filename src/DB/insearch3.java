package DB;
/*
 * ��ʦҳ����Ҫʹ�õĺ���������ѧ�ŵõ�ѧ���༶
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

public class insearch3 {
	String studentNumber,classNumber;
	private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC����
	private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //����Դ 
	Connection conn =null;             //����
	private ResultSet rs = null;//�����
	
	public insearch3(){
		//����JDBC-ODBC����
		try {
			Class.forName(strDBDriver );
		}
		//�����쳣
		catch(java.lang.ClassNotFoundException e){
			System.err.println("insearch():" + e.getMessage());
		}	
	}

	public String get(String studentNumber){
		String strSql = null;
		ArrayList<String> list =new ArrayList<String>();
		try{
			conn = DriverManager.getConnection(strDBUrl);
			Statement stmt = conn.createStatement();
	strSql = "Select ����,�༶ from ѧ��  \r\n" + 
			"where  ѧ��.ѧ�� ='" + studentNumber+"'";
			rs = stmt.executeQuery(strSql);
			while(rs.next()) {		
				return rs.getString("�༶");
			}
		}
		//�����쳣
		catch(SQLException e){
			System.err.println("insearch():"+ e.getMessage());
		}
		return "";
		
	}
	}

