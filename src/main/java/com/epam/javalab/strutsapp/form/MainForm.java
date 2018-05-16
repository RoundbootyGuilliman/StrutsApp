package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import org.apache.struts.action.ActionForm;

import java.util.Map;

public class MainForm extends ActionForm{

	private Map<Integer, NewsDTO> newsMap;

	public Map<Integer, NewsDTO> getNewsMap() {
		return newsMap;
	}

	public void setNewsMap(Map<Integer, NewsDTO> newsMap) {
		this.newsMap = newsMap;
	}
}
