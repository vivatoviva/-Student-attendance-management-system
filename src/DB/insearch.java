package DB;
/*
 * 学生页面需要使用的函数
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
	private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC驱动
	private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //数据源 
	Connection conn =null;             //连接
	private ResultSet rs = null;//结果集
	
	public insearch(){
		//加载JDBC-ODBC驱动
		try {
			Class.forName(strDBDriver );
		}
		//捕获异常
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
	strSql = "Select 姓名,课程名,正常,请假,迟到,早退,旷课  from 学生,出勤表,课程  \r\n" + 
			"where 学生.学号 =出勤表.学号 and 出勤表.课程号 =课程.课程号 and 学生.学号 ='" + studentNumber+"'";
			rs = stmt.executeQuery(strSql);
			while(rs.next()) {		
				list.add(rs.getString("姓名"));
				list.add(rs.getString("课程名"));
				list.add(rs.getInt("正常")+"");
				list.add(rs.getInt("请假")+"");
				list.add(rs.getInt("迟到")+"");
				list.add(rs.getInt("早退")+"");
				list.add(rs.getInt("旷课")+"");
			}
		 data=new String[list.size()/7][7];
		for(int a=0;a<list.size()/7;a++)
			
			for(int i=0;i<7;i++)
				data[a][i]=list.get(a*7+i);
			stmt.close();
			conn.close();
			
		}
	
		//捕获异常
		catch(SQLException e){
			System.err.println("insearch():"+ e.getMessage());
		}
		return data;
		
	}
	}

