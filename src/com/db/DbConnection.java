package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	//Connection�ӿڣ����ţ�
	private static Connection conn;
	//ͨ��setget��������
	//get�����������ŵ�
	public static Connection getConn() {
		try {
			// ���ݿ���������
			//�ɰ�Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			// 2.ʹ���������������ȡ���ݿ����Ӷ���
			/*
			 * (url·������ѡ��һ(1.127.0.0.1:3306/������ 2.localhost:3306/����)
			 * 	      �˺ţ�
			  *          ����)
			 * */
			//?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1WebJdbcStudentģ���ռ���?characterEncoding=utf-8", "root",
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

	//3.�رշ���
	//Result ���������,Statement , Connection ����
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
