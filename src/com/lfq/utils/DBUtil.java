package com.lfq.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static void main(String[]args) throws Exception{
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
        DBUtil.close(conn);
    }
    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        //System.out.println("112");
        Connection conn = null;
        //1.注册驱动（加载驱动）
        final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        final String dburl = "jdbc:mysql://127.0.0.1:3306/mysql?useSSL=false&serverTimezone=GMT";
        final String username="root";
        final String password = "123456";


        //System.out.println("123");
        //		try{
//		Class.forName("com.microsoft.sqlserver.jdbc.Driver");
//		System.out.println("111");
//		//2.建立连接
//		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1443/mydb2","sa","the1012secret");
//		System.out.println("111");
//		}catch(ClassNotFoundException e){
//			//System.out.println("注册驱动");
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
        return conn;
    }
}