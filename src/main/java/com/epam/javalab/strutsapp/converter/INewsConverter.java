package com.epam.javalab.strutsapp.converter;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;

import java.util.Locale;

public interface INewsConverter {

	NewsDTO convertToDTO(News news, Locale locale);
	News convertToEntity(NewsDTO newsDTO);
}
