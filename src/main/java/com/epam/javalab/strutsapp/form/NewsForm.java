package com.epam.javalab.strutsapp.form;

import com.epam.javalab.strutsapp.dto.NewsDTO;
import com.epam.javalab.strutsapp.entity.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class NewsForm extends ActionForm {

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

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		setId(0);
		setNews(new NewsDTO());
	}
}
