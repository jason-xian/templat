package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbConnection;

public class DbHelperDao {
	/**
	 * 通用dao层
	 */
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rst;

	/**
	 * 通用的增删改方法
	 */
	public static int executeUpdate(String sql, Object[] obj) {
		try {
			conn = DbConnection.getConn();
			ps = conn.prepareStatement(sql);
			// 判断数组中是否有参数
			if (obj != null && obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			System.out.println("ps:" + ps.toString());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				return rows;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbConnection.closeAll(null, ps, null,conn);
		}

		return 0;

	}

	/**
	 * 通用的查询方法
	 */
	public static ResultSet executeQuery(String sql, Object[] obj) {
		try {
			conn = DbConnection.getConn();
			System.out.println(conn.toString());
			ps = conn.prepareStatement(sql);
			System.out.println(ps.toString());
			// 判断数组中是否有参数
			if (obj != null && obj.length > 0) {
				System.out.println("666666");
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			rst = ps.executeQuery();
			if (rst != null) {
				System.out.println("2222222");
				return rst;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbConnection.closeAll(null, ps, null,conn);
		}

		return null;

	}

}
