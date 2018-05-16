package com.epam.javalab.strutsapp.service;

import com.epam.javalab.strutsapp.dto.NewsDTO;

import java.util.Locale;
import java.util.Map;

public interface INewsService {

	Map<Integer, NewsDTO> getAllNews(Locale locale);
	NewsDTO getNewsById(int id, Locale locale);
}
