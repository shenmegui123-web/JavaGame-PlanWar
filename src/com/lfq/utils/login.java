package com.lfq.utils;
import com.sun.deploy.association.RegisterFailedException;

import java.sql.*;
import java.util.Scanner;


public class login {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的用户名：");
        String name = scanner.next();
        System.out.print("请输入你的密码：");
        String password = scanner.next();

        boolean flag = new login().register(name, password);
        while (!flag) {
            System.out.print("注册失败，请重新输入用户名：");
            name = scanner.next();
            System.out.print("请输入你的密码：");
            password = scanner.next();
            flag = new login().register(name, password);
        }
        System.out.println("注册成功");
    }

    public boolean register(String username, String password) throws Exception{
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            //定义sql
            String sql = "select * from login where name='" + username + "'";
            //获取执行sql对象
            stmt = conn.createStatement();
            //执行查询
            rs = stmt.executeQuery(sql);
            if (rs.next()) return false;     //因为查询到此账户，所以拒绝注册
            //定义sql
            sql = "INSERT into login(name,password) value ('" + username + "','" + password + "')";
            //执行查询
            int count = stmt.executeUpdate(sql);
            return count != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return false;
    }


    //登录方法
    public boolean sign(String username, String password) throws SQLException {

        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            //定义sql
            String sql = "select * from login123 where name='" + username + "' and password ='" + password + "' ";
            //获取执行sql对象
            stmt = conn.createStatement();
            //执行查询
            rs = stmt.executeQuery(sql);

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();

            return false;
        }
    }

}