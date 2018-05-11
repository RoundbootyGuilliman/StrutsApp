package com.epam.javalab.strutsapp.dao;

import com.epam.javalab.strutsapp.entity.News;

import java.util.Map;

public interface INewsDAO {

	Map<Integer, News> getAllNews();
	News getNewsById(int id);
}
