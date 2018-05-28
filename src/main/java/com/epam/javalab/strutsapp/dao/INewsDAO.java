package com.epam.javalab.strutsapp.dao;

import com.epam.javalab.strutsapp.entity.News;

import java.util.List;

public interface INewsDAO {

	List<News> getAllNews();
	News getNewsById(int id);
	List<News> getNewsByAuthor(String username);
	void saveNews(News news);
	void deleteNews(int id);
}
