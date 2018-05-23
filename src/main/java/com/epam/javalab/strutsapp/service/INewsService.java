package com.epam.javalab.strutsapp.service;

import com.epam.javalab.strutsapp.dto.NewsDTO;

import java.util.List;

public interface INewsService {

	List<NewsDTO> getAllNews();
	NewsDTO getNewsById(int id);
	void setNews(NewsDTO newsDTO);
	void deleteNews(int id);
}
