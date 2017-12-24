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
		private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC驱动
		private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //数据源 
		Connection conn =null;             //连接
		private ResultSet rs = null;//结果集
		public Update(){
			//加载JDBC-ODBC驱动
			try {
				Class.forName(strDBDriver );
			}
			//捕获异常
			catch(java.lang.ClassNotFoundException e){
				System.err.println("insearch():" + e.getMessage());
			}	
		}
		//teacherpage使用
		public void updateKaoqing(String stunumber,String classnumber,String zhuangtai){ 
			String strSql = null;
			//ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
				strSql =  " update 出勤表 set "+zhuangtai+"="+zhuangtai+"+1 where 学号='"+stunumber +"' and 课程号= '"+classnumber+"'";
			 	stmt.executeUpdate(strSql);
			}
			catch(SQLException e){
				System.err.println("Update():"+ e.getMessage());
			}
		}
		//adminpage使用
		public void updateMessage(String stunumber,String name,String classnum){ 
			String strSql = null;
			//ArrayList<String> list =new ArrayList<String>();
			try{
				conn = DriverManager.getConnection(strDBUrl);
				Statement stmt = conn.createStatement();
				strSql =  "  update 学生\r\n" + 
					" set 姓名='"+name+"' ,  班级='"+classnum+"'\r\n" + 
					" where 学号='"+stunumber+"'";
			 stmt.executeUpdate(strSql);
			}
			catch(SQLException e){
				
				System.err.println("Update():"+ e.getMessage());
			}
		}
}
