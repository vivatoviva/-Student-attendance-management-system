package DB;
/*
 * adminҳ����Ҫʹ�õĺ���
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
	private static String strDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //JDBC����
	private static String strDBUrl = "jdbc:sqlserver://localhost:1433;databaseName=kaoqin;user=sa;password= 123";   //����Դ 
		Connection conn =null;             //����
	private ResultSet rs = null;//�����
	
	public insearch2(){
		//����JDBC-ODBC����
		try {
			Class.forName(strDBDriver );
		}
		//�����쳣
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
			strSql = "select ѧ�� = ѧ��.ѧ��,����,�༶,���ڴ���=sum(����)+SUM(�ٵ�)+SUM(����)+SUM(���)+SUM(����),��ٴ���=sum(���),������� = SUM(�ٵ�)+SUM(����)+SUM(����)from ѧ��,���ڱ�,�γ� where ѧ��.ѧ�� =���ڱ�.ѧ�� and ���ڱ�.�γ̺� =�γ�.�γ̺� group by ѧ��.ѧ��,ѧ��.����,ѧ��.�༶";
			rs = stmt.executeQuery(strSql);

			while(rs.next()) {
				list.add(rs.getString("ѧ��"));
				list.add(rs.getString("����")+"");
				list.add(rs.getString("�༶")+"");
				list.add(rs.getInt("���ڴ���")+"");
				list.add(rs.getInt("��ٴ���")+"");
				list.add(rs.getInt("�������")+"");
			}
		for(int i=0;i<list.size();i++)System.out.print(list.get(i));
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

	}



