package com.epam.javalab.strutsapp.converter.impl;

import com.epam.javalab.strutsapp.converter.INewsConverter;
import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class NewsConverter implements INewsConverter {

	@Override
	public NewsDTO convertToDTO(News news) {
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setId(news.getId());
		newsDTO.setTitle(news.getTitle());
		newsDTO.setAuthor(news.getAuthor());
		newsDTO.setDate(news.getDate());
		newsDTO.setBrief(news.getBrief());
		newsDTO.setContent(news.getContent());
		newsDTO.setComments(news.getComments());
		return newsDTO;
	}

	@Override
	public News convertToEntity(NewsDTO newsDTO) {
		News news = new News();
		news.setId(newsDTO.getId());
		news.setTitle(newsDTO.getTitle());
		news.setAuthor(newsDTO.getAuthor());
		news.setDate(newsDTO.getDate());
		news.setBrief(newsDTO.getBrief());
		news.setContent(newsDTO.getContent());
		news.setComments(newsDTO.getComments());
		return news;
	}
}
