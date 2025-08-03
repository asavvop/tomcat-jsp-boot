package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class DbServletOne extends HttpServlet {
	
	private DataSource ds;

	public DbServletOne(@Qualifier("pecamDataSource") DataSource ds) {
		super();
		this.ds = ds;
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		ServletOutputStream out = resp.getOutputStream();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select id, name, description from test_table");
			while (rs.next()) {
				out.println("From Hikary: Id = " + rs.getInt("id") + ", Name = " + rs.getString("name") + ", Description = "
						+ rs.getString("description"));
			}
		} catch (SQLException e) {
			out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				out.println(e.getMessage());
			}
		}

	}

}