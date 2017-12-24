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
		private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC驱动
		private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //数据源 
		Connection conn =null;             //连接
		private ResultSet rs = null;//结果集
		
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
		strSql = "Select 姓名,课程名,正常,请假,迟到,早退,旷课  from 学生,出勤表,课程  \r\n" + 
				"where 学生.学号 =出勤表.学号 and 出勤表.课程号 =课程.课程号 and 学生.学号 =" + studentNumber;
				rs = stmt.executeQuery(strSql);
				System.out.println(rs.getRow());
				while(rs.next()) {
				
					System.out.println(rs.getRow());
					list.add(rs.getString("姓名"));
					list.add(rs.getString("课程名"));
					list.add(rs.getInt("正常")+"");
					list.add(rs.getInt("请假")+"");
					list.add(rs.getInt("迟到")+"");
					list.add(rs.getInt("早退")+"");
					list.add(rs.getInt("旷课")+"");
					
					
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
		
			//捕获异常
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
		strSql = "select 班级,姓名 from 课程,dbo.学生,出勤表\r\n" + 
				"where 学生.学号 =出勤表.学号 and 出勤表.课程号 =课程.课程号 And 出勤表.课程号='"+classNumber+"'";
				rs = stmt.executeQuery(strSql);
				System.out.println(rs);
				System.out.println(rs.getRow());
				while(rs.next()) {
				
					//System.out.println(rs.getRow());
					list.add(rs.getString("班级"));
					list.add(rs.getString("姓名"));
					System.out.println(rs.getString("班级"));
					list.add("正常");
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
		
			//捕获异常
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
		strSql = "select 姓名,sum(正常)as '1',sum(请假)as '2',sum(迟到)as '3',sum(早退)as '4',sum(旷课)as '5'\r\n" + 
				"from 学生,出勤表,课程 where 学生.学号 =出勤表.学号 and 出勤表.课程号 =课程.课程号 group by 学生.学号,学生.姓名";
				rs = stmt.executeQuery(strSql);
				System.out.println(rs);
				System.out.println(rs.getRow());
				while(rs.next()) {
				
					//System.out.println(rs.getRow());
					list.add(rs.getString("姓名"));
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
		
			//捕获异常
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
