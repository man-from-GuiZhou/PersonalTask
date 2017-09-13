package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

import dao.DataSource;
import dao.impl.SimpleConnection;

public class JDBCUtils {
	private static DataSource ds = new SimpleConnection();
	
	public static Connection getConnection() {
		return ds.getConnection();
	}
	public static void release(Connection conn,PreparedStatement st,ResultSet rs){
		 if(rs!=null){
	            try{//关闭存储查询结果的ResultSet对象
	                rs.close();
	            }catch (Exception e) {
	                e.printStackTrace();
	            }
	            rs = null;
	        }
	        if(st!=null){
	            try{
	                //关闭负责执行SQL命令的Statement对象
	                st.close();
	            }catch (Exception e) {
	                e.printStackTrace(); 
	            }
	        }
	        
	        if(conn!=null){
	            try{
	                //关闭Connection数据库连接对象
	                conn.close();
	            }catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	}
}
