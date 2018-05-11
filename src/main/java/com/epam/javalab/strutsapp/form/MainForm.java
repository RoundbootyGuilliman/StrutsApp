package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.entity.News;
import org.apache.struts.action.ActionForm;

import java.util.Map;

public class MainForm extends ActionForm{

	private Map<Integer, News> newsMap;

	public Map<Integer, News> getNewsMap() {
		return newsMap;
	}

	public void setNewsMap(Map<Integer, News> newsMap) {
		this.newsMap = newsMap;
	}
}
