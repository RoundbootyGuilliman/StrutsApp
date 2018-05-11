package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.entity.News;
import org.apache.struts.action.ActionForm;

import java.util.List;

public class MainForm extends ActionForm{

	List<News> newsList;

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
