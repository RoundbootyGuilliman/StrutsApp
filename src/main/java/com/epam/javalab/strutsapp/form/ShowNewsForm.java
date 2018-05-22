package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;
import org.apache.struts.action.ActionForm;

public class ShowNewsForm extends ActionForm {

	private int id;
	private NewsDTO news;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NewsDTO getNews() {
		return news;
	}

	public void setNews(NewsDTO news) {
		this.news = news;
	}
}
