package com.epam.javalab.strutsapp.service.impl;

import com.epam.javalab.strutsapp.converter.INewsConverter;
import com.epam.javalab.strutsapp.converter.impl.NewsConverter;
import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;
import com.epam.javalab.strutsapp.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class NewsService implements INewsService {

	@Autowired
	@Qualifier("newsDAO")
	private INewsDAO newsDAO;
	private INewsConverter converter = new NewsConverter();

	@Override
	public Map<Integer, NewsDTO> getAllNews(Locale locale) {

		Map<Integer, News> newsMap = newsDAO.getAllNews();
		Map<Integer, NewsDTO> newsDTOMap = new HashMap<>();

		for (Map.Entry<Integer, News> entry : newsMap.entrySet()) {
			newsDTOMap.put(entry.getKey(), converter.convertToDTO(entry.getValue(), locale));
		}

		return newsDTOMap;
	}

	@Override
	public NewsDTO getNewsById(int id, Locale locale) {

		News news = newsDAO.getNewsById(id);

		return converter.convertToDTO(news, locale);
	}
}
