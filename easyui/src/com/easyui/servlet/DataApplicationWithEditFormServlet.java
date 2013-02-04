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
	 * �༭ĳ���û���Ϣ
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

		// �������
		Connection conn = ConnUtils.getConn();

		PreparedStatement pstmt = null;

		StringBuilder updateUserSql = new StringBuilder("  ");

		updateUserSql
				.append(" UPDATE USERS SET FIRSTNAME=?, LASTNAME=?, PHONE=?, EMAIL=? WHERE ID=?");

		// String returnFlag = "0|����ʧ��";

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
			 * if(n == 1) {//��ʾ ���³ɹ�
			 * 
			 * returnFlag = "1|���³ɹ�";
			 * 
			 * } else {
			 * 
			 * returnFlag = "0|����ʧ��";
			 * 
			 * }
			 */

			if (n == 1) {

				map.put("success", "true");

				map.put("msg", "���³ɹ� ");

			} else {

				map.put("success", "false");

				map.put("msg", "����ʧ�� ");

			}

			// response.setContentType("text/json;charset=UTF-8");//��ֹ������������

			String returnFlag = JSONObject.fromObject(map).toString();

			PrintWriter out = response.getWriter();

			out.println(returnFlag);

			out.flush();

			out.close();

			System.err.println("���µļ�¼����Ϊ��[" + n + "]����SQLΪ["
					+ updateUserSql.toString() + "]������Ϊid[" + id
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

		request.setCharacterEncoding("UTF-8");// ������������ʽ

		response.setCharacterEncoding("UTF-8");

		response.setHeader("Cache-Control", "no-cache");// ��ֹ����

		response.setContentType("text/json;charset=UTF-8");// ��ֹ������������

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
	 * ����û�
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
		// �������
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

				map.put("msg", "��ӳɹ� ");

			} else {

				map.put("success", "false");

				map.put("msg", "���ʧ�� ");

			}

			String returnFlag = JSONObject.fromObject(map).toString();

			PrintWriter out = response.getWriter();

			out.println(returnFlag);

			out.flush();

			out.close();

			System.err.println("��ӵļ�¼����Ϊ��[" + n + "]����SQLΪ["
					+ addUserSql.toString() + "]������ΪifirstName:[" + firstName
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
		// �������
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

				map.put("msg", "ɾ��ɹ� ");

			} else {

				map.put("success", "false");

				map.put("msg", "ɾ�� ʧ�� ");

			}

			String returnFlag = JSONObject.fromObject(map).toString();

			PrintWriter out = response.getWriter();

			out.println(returnFlag);

			out.flush();

			out.close();

			System.err.println("ɾ��ļ�¼����Ϊ��[" + n + "]����SQLΪ["
					+ deleteUserSql.toString() + "]������Ϊid[" + id + "]");

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnUtils.releaseConn(null, pstmt, conn);

		}

	}

	/**
	 * ��ѯ�����û�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAllUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// �������
		Connection conn = ConnUtils.getConn();

		// ҳ��
		String pageCount = request.getParameter("page");

		long page = (pageCount == null || "".equals(pageCount)) ? 1 : Long
				.valueOf(pageCount);

		String rowsCount = request.getParameter("rows");

		// ����
		long rows = (rowsCount == null || "".equals(rowsCount)) ? 10 : Long
				.valueOf(rowsCount);

		// ��ʼ��¼������һҳ����0 ��ʼ���ڶ�ҳ����10��ʼ
		long offSet = (page - 1) * rows;

		Map<String, Object> returnMap = new HashMap<String, Object>();

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		// ��ѯ���еļ�¼����SQL
		StringBuilder allCountSql = new StringBuilder("  ");

		allCountSql.append(" SELECT COUNT(*) FROM USERS ");

		long allCount = 0;

		// ��ѯĳҳ�ļ�¼,���ҳ���ÿҳ��¼��,ȷ��Ӧ�ò����ʼ��¼����ֹ��¼
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

			response.setCharacterEncoding("UTF-8");// ���ñ����ʽ

			PrintWriter out = response.getWriter();

			out.println(returnString);// ����JSON��

			out.flush();

			out.close();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnUtils.releaseConn(rs, pstmt, conn);// �ر�����

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
