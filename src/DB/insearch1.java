package DB;
/*
 * 教师页面需要使用的函数
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
		private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC驱动
		private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //数据源 
				Connection conn =null;             //连接
		private ResultSet rs = null;//结果集
		
		public insearch1(){
			//加载JDBC-ODBC驱动
			try {
				Class.forName(strDBDriver );
			}
			//捕获异常
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
				strSql = "select 学生.学号,班级,姓名 from 课程,dbo.学生,出勤表\r\n" + 
				"where 学生.学号 =出勤表.学号 and 出勤表.课程号 =课程.课程号 And 出勤表.课程号='"+classNumber+"'";
				rs = stmt.executeQuery(strSql);;
				while(rs.next()) {
					list.add(rs.getString("学号"));
					list.add(rs.getString("姓名"));
					list.add("正常");
				}
			 
			data=new String[list.size()/3][3];
			
			for(int a=0;a<list.size()/3;a++)
				
				for(int i=0;i<3;i++)
					data[a][i]=list.get(a*3+i);
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

