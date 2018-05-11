package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.entity.News;
import org.apache.struts.action.ActionForm;

public class NewsForm extends ActionForm {

	News news;
	int id;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}