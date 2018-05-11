package com.epam.javalab.strutsapp.dao.impl;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.entity.News;

import java.sql.Connection;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NewsDAO implements INewsDAO {

	private String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String userid = "sys as sysdba";
	private String password = "Oracle_1";

	private Connection conn;

	public NewsDAO() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setURL(jdbcUrl);
			conn = dataSource.getConnection(userid, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Map<Integer, News> getAllNews() {
		Map<Integer, News> newsMap = new HashMap<>();
		News news = new News();
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM NEWS");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				news.setId(resultSet.getInt(1));
				news.setTitle(resultSet.getString(2));
				news.setAuthor(resultSet.getString(3));
				news.setTime(resultSet.getLong(4));
				news.setBrief(resultSet.getString(5));
				news.setContent(resultSet.getString(6));
				newsMap.put(news.getId(), news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsMap;
	}

	public News getNewsById(int id) {
		News news = new News();
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM NEWS WHERE ID=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				news.setId(resultSet.getInt(1));
				news.setTitle(resultSet.getString(2));
				news.setAuthor(resultSet.getString(3));
				news.setTime(resultSet.getLong(4));
				news.setBrief(resultSet.getString(5));
				news.setContent(resultSet.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}
}
