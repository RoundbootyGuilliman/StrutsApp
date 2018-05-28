package com.epam.javalab.strutsapp.service.impl;

import com.epam.javalab.strutsapp.converter.INewsConverter;
import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;
import com.epam.javalab.strutsapp.entity.Role;
import com.epam.javalab.strutsapp.entity.User;
import com.epam.javalab.strutsapp.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NewsService implements INewsService {

	@Autowired
	private INewsDAO newsDAO;
	@Autowired
	private INewsConverter converter;

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
		return converter.convertToDTO(newsDAO.getNewsById(id));
	}

	@Override
	public List<NewsDTO> getNewsByAuthor(String username) {
		List<News> newsList = newsDAO.getNewsByAuthor(username);
		List<NewsDTO> newsDTOList = new ArrayList<>();
		for (News news : newsList) {
			newsDTOList.add(converter.convertToDTO(news));
		}
		return newsDTOList;
	}

	@Override
	public void setNews(NewsDTO newsDTO) {
		newsDAO.saveNews(converter.convertToEntity(newsDTO));
	}

	@Override
	public void deleteNews(int id) {
		newsDAO.deleteNews(id);
	}
}
