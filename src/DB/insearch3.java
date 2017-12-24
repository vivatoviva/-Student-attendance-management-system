package DB;
/*
 * 老师页面需要使用的函数，传入学号得到学生班级
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
	private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC驱动
	private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //数据源 
	Connection conn =null;             //连接
	private ResultSet rs = null;//结果集
	
	public insearch3(){
		//加载JDBC-ODBC驱动
		try {
			Class.forName(strDBDriver );
		}
		//捕获异常
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
	strSql = "Select 姓名,班级 from 学生  \r\n" + 
			"where  学生.学号 ='" + studentNumber+"'";
			rs = stmt.executeQuery(strSql);
			while(rs.next()) {		
				return rs.getString("班级");
			}
		}
		//捕获异常
		catch(SQLException e){
			System.err.println("insearch():"+ e.getMessage());
		}
		return "";
		
	}
	}

