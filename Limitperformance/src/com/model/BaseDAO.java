package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BaseDAO {
	
	public static final String DRIVE_NAME =  "com.mysql.jdbc.Driver";  
	public  static final String CONN_STR = "jdbc:mysql://localhost:3306/limitpro";  
	public  static final String USERNAME = "root";  
	public  static final String PWD = "root"; 
	
	Connection conn = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public int save(String loginname,String loginpassword){
		int insertRows = 0;
		try {
			Class.forName(DRIVE_NAME);
			conn = DriverManager.getConnection(CONN_STR,
					USERNAME, PWD);
			String sql = "insert into users(loginname,loginpassword) values (?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, loginname);
			pst.setString(2, loginpassword);

			insertRows = pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类！");
		} catch (SQLException e) {
			System.out.println("数据库操作出错！");
		} finally {
			closeResource();
		}
		return insertRows;
	}
	
	public int delete(int userid){			//工作正常为1 如果找不到为-2
		int insertRows = 0;
		try {
			Class.forName(DRIVE_NAME);
			conn = DriverManager.getConnection(CONN_STR,
					USERNAME, PWD);
			String sql = "selsect count(*) from users where userid = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userid); // 创建处理SQL执行语句
			rs.next();
			int res = rs.getInt(1); // 处理执行结果
			if (res == 1) {
				String sql2 = "delete * from users where id = ?";

				pst = conn.prepareStatement(sql2);
				pst.setInt(1, userid);
				insertRows = pst.executeUpdate();
			} else {
				return -2;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类！");
		} catch (SQLException e) {
			System.out.println("数据库操作出错！");
		} finally {
			closeResource();
		}
		return insertRows;
	}
	
	public int modify(int userid,String loginpassword,String nickname){
		int insertRows = 0;
		try {
			Class.forName(DRIVE_NAME);
			conn = DriverManager.getConnection(CONN_STR,
					USERNAME, PWD);
			String sql = "selsect count(*) from users where id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userid); // 创建处理SQL执行语句
			pst.setString(2,loginpassword);
			pst.setString(3,nickname);
			rs.next();
			int res = rs.getInt(1); // 处理执行结果
			if (res == 1) {
				String sql2 = "update users set newloginpassword="+loginpassword+",newnickname="+nickname+" where id = ?";

				pst = conn.prepareStatement(sql2);
				pst.setInt(1, userid);
				insertRows = pst.executeUpdate();
			} else {
				return -2;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类！");
		} catch (SQLException e) {
			System.out.println("数据库操作出错！");
		} finally {
			closeResource();
		}
		return insertRows;
	}
	
	public List<User> select(){
		List<User> list = new ArrayList<User>();
		try {
			Class.forName(DRIVE_NAME);
			conn = DriverManager.getConnection(CONN_STR,
					USERNAME,PWD);
			String sql = "select * from users ";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				User us = new User();

				us.setUserid(rs.getInt("userid"));
				us.setLoginname(rs.getString("loginname"));
				us.setLoginpassword(rs.getString("loginpassword"));
				us.setNickname(rs.getString("nickname"));

				list.add(us);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类！");
		} catch (SQLException e) {
			System.out.println("数据库操作出错！");
		} finally {
			closeResource();
		}

		return list;
	}
	
	
	
	public void closeResource() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			System.out.println("数据库操作出错！");
		}
	}
}
