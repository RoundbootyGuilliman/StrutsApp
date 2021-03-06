package com.epam.javalab.strutsapp.converter.impl;

import com.epam.javalab.strutsapp.converter.INewsConverter;
import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;
import com.epam.javalab.strutsapp.util.TimeAndDateHandler;

import java.util.Locale;

public class NewsConverter implements INewsConverter {

	@Override
	public NewsDTO convertToDTO(News news, Locale locale) {

		NewsDTO newsDTO = new NewsDTO();

		newsDTO.setId(news.getId());
		newsDTO.setTitle(news.getTitle());
		newsDTO.setAuthor(news.getAuthor());
		newsDTO.setTime(news.getTime());
		newsDTO.setDate(TimeAndDateHandler.setDate(news.getTime(), locale));
		newsDTO.setBrief(news.getBrief());
		newsDTO.setContent(news.getContent());

		return newsDTO;
	}

	@Override
	public News convertToEntity(NewsDTO newsDTO) {

		News news = new News();

		news.setId(newsDTO.getId());
		news.setTitle(newsDTO.getTitle());
		news.setAuthor(newsDTO.getAuthor());
		news.setTime(newsDTO.getTime());
		news.setBrief(newsDTO.getBrief());
		news.setContent(newsDTO.getContent());

		return news;
	}
}
