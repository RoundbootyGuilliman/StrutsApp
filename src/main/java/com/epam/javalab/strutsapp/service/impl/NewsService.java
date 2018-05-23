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

import java.util.*;

@Component
public class NewsService implements INewsService {

	@Autowired
	@Qualifier("newsDAO")
	private INewsDAO newsDAO;
	private INewsConverter converter = new NewsConverter();

	@Override
	public List<NewsDTO> getAllNews() {

		List<News> newsList = newsDAO.getAllNews();
		List<NewsDTO> newsDTOList = new ArrayList<>();

		for (News news : newsList) {
			newsDTOList.add(converter.convertToDTO(news));
		}

		return newsDTOList;
	}

	@Override
	public NewsDTO getNewsById(int id) {

		News news = newsDAO.getNewsById(id);

		return converter.convertToDTO(news);
	}

	@Override
	public void setNews(NewsDTO newsDTO) {
		News news = converter.convertToEntity(newsDTO);
		newsDAO.saveNews(news);
	}

	@Override
	public void deleteNews(int id) {
		newsDAO.deleteNews(id);
	}
}
