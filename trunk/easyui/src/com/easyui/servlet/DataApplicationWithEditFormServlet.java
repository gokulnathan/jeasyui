package com.easyui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.easyui.common.ConnUtils;

/**
 * DataApplicationWithEditFormServlet
 * 
 * @author AB029789
 * 
 */
public class DataApplicationWithEditFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* private JSONObject easyJson; */

	/**
	 * Constructor of the object.
	 */
	public DataApplicationWithEditFormServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);

	}

	/**
	 * 编辑某个用户信息
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 * @throws IOException
	 */
	private void editUser(String id, String firstName, String lastName,
			String phone, String email, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// 获得连接
		Connection conn = ConnUtils.getConn();

		PreparedStatement pstmt = null;

		StringBuilder updateUserSql = new StringBuilder("  ");

		updateUserSql
				.append(" UPDATE USERS SET FIRSTNAME=?, LASTNAME=?, PHONE=?, EMAIL=? WHERE ID=?");

		// String returnFlag = "0|更新失败";

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			pstmt = conn.prepareStatement(updateUserSql.toString());

			pstmt.setString(1, firstName);

			pstmt.setString(2, lastName);

			pstmt.setString(3, phone);

			pstmt.setString(4, email);

			pstmt.setString(5, id);

			int n = pstmt.executeUpdate();

			/*
			 * if(n == 1) {//表示 更新成功
			 * 
			 * returnFlag = "1|更新成功";
			 * 
			 * } else {
			 * 
			 * returnFlag = "0|更新失败";
			 * 
			 * }
			 */

			if (n == 1) {

				map.put("success", "true");

				map.put("msg", "更新成功 ");

			} else {

				map.put("success", "false");

				map.put("msg", "更新失败 ");

			}

			// response.setContentType("text/json;charset=UTF-8");//防止出现中文乱码

			String returnFlag = JSONObject.fromObject(map).toString();

			PrintWriter out = response.getWriter();

			out.println(returnFlag);

			out.flush();

			out.close();

			System.err.println("更新的记录条数为：[" + n + "]条，SQL为["
					+ updateUserSql.toString() + "]，参数为id[" + id
					+ "],firstName:[" + firstName + "],lastName:[" + lastName
					+ "],phone:[" + phone + "],email:[" + email + "]");

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnUtils.releaseConn(null, pstmt, conn);

		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");// 设置请求编码格式

		response.setCharacterEncoding("UTF-8");

		response.setHeader("Cache-Control", "no-cache");// 防止缓存

		response.setContentType("text/json;charset=UTF-8");// 防止出现中文乱码

		String flag = request.getParameter("flag");

		if (flag == null || "".equals(flag.trim())) {

			this.searchAllUsers(request, response);

		} else if ("edit".equals(flag.trim())) {

			String id = request.getParameter("id");// primary key

			String firstName = request.getParameter("firstName");// first name

			String lastName = request.getParameter("lastName");// last name

			String phone = request.getParameter("phone");// phone

			String email = request.getParameter("email");// email

			this.editUser(id, firstName, lastName, phone, email, request,
					response);

		} else if ("remove".equals(flag.trim())) {

			String id = request.getParameter("id");// primary key

			this.deleteUser(id, request, response);

		} else if ("addNew".equals(flag.trim())) {

			String firstName = request.getParameter("firstName");// first name

			String lastName = request.getParameter("lastName");// last name

			String phone = request.getParameter("phone");// phone

			String email = request.getParameter("email");// email

			this.addUser(firstName, lastName, phone, email, request, response);

		}

	}

	/**
	 * 添加用户
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void addUser(String firstName, String lastName, String phone,
			String email, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获得连接
		Connection conn = ConnUtils.getConn();

		PreparedStatement pstmt = null;

		StringBuilder addUserSql = new StringBuilder("  ");

		addUserSql
				.append(" INSERT INTO USERS (FIRSTNAME, LASTNAME, PHONE, EMAIL) VALUES(? ,? ,?, ?)");

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			pstmt = conn.prepareStatement(addUserSql.toString());

			pstmt.setString(1, firstName);

			pstmt.setString(2, lastName);

			pstmt.setString(3, phone);

			pstmt.setString(4, email);

			int n = pstmt.executeUpdate();

			if (n == 1) {

				map.put("success", "true");

				map.put("msg", "添加成功 ");

			} else {

				map.put("success", "false");

				map.put("msg", "添加失败 ");

			}

			String returnFlag = JSONObject.fromObject(map).toString();

			PrintWriter out = response.getWriter();

			out.println(returnFlag);

			out.flush();

			out.close();

			System.err.println("添加的记录条数为：[" + n + "]条，SQL为["
					+ addUserSql.toString() + "]，参数为ifirstName:[" + firstName
					+ "],lastName:[" + lastName + "],phone:[" + phone
					+ "],email:[" + email + "]");

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnUtils.releaseConn(null, pstmt, conn);

		}

	}

	private void deleteUser(String id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获得连接
		Connection conn = ConnUtils.getConn();

		PreparedStatement pstmt = null;

		StringBuilder deleteUserSql = new StringBuilder("  ");

		deleteUserSql.append(" DELETE FROM USERS WHERE ID=?");

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			pstmt = conn.prepareStatement(deleteUserSql.toString());

			pstmt.setString(1, id);

			int n = pstmt.executeUpdate();

			if (n == 1) {

				map.put("success", "true");

				map.put("msg", "删除成功 ");

			} else {

				map.put("success", "false");

				map.put("msg", "删除 失败 ");

			}

			String returnFlag = JSONObject.fromObject(map).toString();

			PrintWriter out = response.getWriter();

			out.println(returnFlag);

			out.flush();

			out.close();

			System.err.println("删除的记录条数为：[" + n + "]条，SQL为["
					+ deleteUserSql.toString() + "]，参数为id[" + id + "]");

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnUtils.releaseConn(null, pstmt, conn);

		}

	}

	/**
	 * 查询所有用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAllUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获得连接
		Connection conn = ConnUtils.getConn();

		// 页码
		String pageCount = request.getParameter("page");

		long page = (pageCount == null || "".equals(pageCount)) ? 1 : Long
				.valueOf(pageCount);

		String rowsCount = request.getParameter("rows");

		// 行数
		long rows = (rowsCount == null || "".equals(rowsCount)) ? 10 : Long
				.valueOf(rowsCount);

		// 起始记录数，比如第一页，从0 开始，第二页，从10开始
		long offSet = (page - 1) * rows;

		Map<String, Object> returnMap = new HashMap<String, Object>();

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		// 查询所有的记录条数SQL
		StringBuilder allCountSql = new StringBuilder("  ");

		allCountSql.append(" SELECT COUNT(*) FROM USERS ");

		long allCount = 0;

		// 查询某页的记录,根据页码和每页记录数,确定应该查的起始记录和终止记录
		StringBuilder searchSql = new StringBuilder("  ");

		searchSql
				.append(" SELECT ID, FIRSTNAME, LASTNAME, PHONE, EMAIL FROM USERS LIMIT ?,? ");

		try {

			pstmt = conn.prepareStatement(allCountSql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {

				allCount = rs.getLong(1);

			}

			returnMap.put("total", allCount);

			pstmt = conn.prepareStatement(searchSql.toString());

			pstmt.setLong(1, offSet);

			pstmt.setLong(2, rows);

			rs = pstmt.executeQuery();

			List<Users> result = new ArrayList<Users>();

			while (rs.next()) {

				Users user = new Users();

				user.setId(rs.getLong("ID"));

				user.setFirstName(rs.getString("FIRSTNAME"));

				user.setLastName(rs.getString("LASTNAME"));

				user.setPhone(rs.getString("PHONE"));

				user.setEmail(rs.getString("EMAIL"));

				result.add(user);

			}

			returnMap.put("rows", result);

			String returnString = JSONObject.fromObject(returnMap).toString();

			System.err.println(returnString);

			response.setContentType("text/html");

			response.setCharacterEncoding("UTF-8");// 设置编码格式

			PrintWriter out = response.getWriter();

			out.println(returnString);// 输入JSON串

			out.flush();

			out.close();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnUtils.releaseConn(rs, pstmt, conn);// 关闭连接

		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {

	}

	/*
	 * public JSONObject getEasyJson() { return easyJson; }
	 * 
	 * public void setEasyJson(JSONObject easyJson) { this.easyJson = easyJson;
	 * }
	 */

}
