package DB;
/*
 * admin页面需要使用的函数
 */
import java.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class insearch2 {
	String data[][];
	private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC驱动
	private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //数据源 
		Connection conn =null;             //连接
	private ResultSet rs = null;//结果集
	
	public insearch2(){
		//加载JDBC-ODBC驱动
		try {
			Class.forName(strDBDriver );
		}
		//捕获异常
		catch(java.lang.ClassNotFoundException e){
			System.err.println("insearch2():" + e.getMessage());
		}	
	}

	public String[][] get(){
		String strSql = null;
		
		ArrayList<String> list =new ArrayList<String>();
		try{
			conn = DriverManager.getConnection(strDBUrl);
			Statement stmt = conn.createStatement();
			strSql = "select 学号 = 学生.学号,姓名,班级,考勤次数=sum(正常)+SUM(迟到)+SUM(旷课)+SUM(请假)+SUM(早退),请假次数=sum(请假),其他情况 = SUM(迟到)+SUM(旷课)+SUM(早退)from 学生,出勤表,课程 where 学生.学号 =出勤表.学号 and 出勤表.课程号 =课程.课程号 group by 学生.学号,学生.姓名,学生.班级";
			rs = stmt.executeQuery(strSql);

			while(rs.next()) {
				list.add(rs.getString("学号"));
				list.add(rs.getString("姓名")+"");
				list.add(rs.getString("班级")+"");
				list.add(rs.getInt("考勤次数")+"");
				list.add(rs.getInt("请假次数")+"");
				list.add(rs.getInt("其他情况")+"");
			}
		for(int i=0;i<list.size();i++)System.out.print(list.get(i));
		data=new String[list.size()/6][6];
		for(int a=0;a<list.size()/6;a++)
			
			for(int i=0;i<6;i++)
				data[a][i]=list.get(a*6+i);
			stmt.close();
			conn.close();
			
		}
	
		//捕获异常
		catch(SQLException e){
			System.err.println("insearch2():"+ e.getMessage());
		}
		return data;
		
	}

	}



