package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	//Connection接口（搭桥）
	private static Connection conn;
	//通过setget方法调用
	//get是用来调用桥的
	public static Connection getConn() {
		try {
			// 数据库驱动加载
			//旧版Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			// 2.使用驱动管理器类获取数据库连接对象
			/*
			 * (url路径，任选其一(1.127.0.0.1:3306/库名； 2.localhost:3306/库名)
			 * 	      账号，
			  *          密码)
			 * */
			//?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1WebJdbcStudent模板终极版?characterEncoding=utf-8", "root",
					"asdasd");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	//3.关闭方法
	//Result 结果集对象,Statement , Connection 桥梁
	public static void closeAll(ResultSet rst, PreparedStatement ps, Statement st, Connection conn) {
		try {
			if (rst != null)
				rst.close();
			if (ps != null)
				ps.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
