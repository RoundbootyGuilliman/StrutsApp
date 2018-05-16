package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import org.apache.struts.action.ActionForm;

public class NewsForm extends ActionForm {

	private NewsDTO news;
	private int id;

	public NewsDTO getNews() {
		return news;
	}

	public void setNews(NewsDTO news) {
		this.news = news;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}