package com.easyui.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接辅助工具 
 * 
 * @author AB029789
 * 
 */
public class ConnUtils {

	private static final String url = "jdbc:mysql://localhost:3306/test";

	private static final String userName = "root";

	private static final String pwd = "root";

	public static Connection getConn() {
		Connection conn = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, userName, pwd);

		} catch (ClassNotFoundException e) {

			System.err.println("ConnUtils获得连接失败:" + e);

		} catch (SQLException e) {

			System.err.println("ConnUtils SQLException 获得连接失败:" + e);

		}

		return conn;
	}

	public static void releaseConn(ResultSet rs, Statement stmt, Connection conn) {

		try {

			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				if (!conn.getAutoCommit()) {
					conn.setAutoCommit(true);
				}
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.err.println(getConn());
	}

}
