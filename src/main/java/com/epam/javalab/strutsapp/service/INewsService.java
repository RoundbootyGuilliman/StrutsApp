package com.epam.javalab.strutsapp.service;

import com.epam.javalab.strutsapp.dto.NewsDTO;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface INewsService {

	List<NewsDTO> getAllNews(Locale locale);
	NewsDTO getNewsById(int id, Locale locale);
	void setNews(NewsDTO newsDTO);
}
