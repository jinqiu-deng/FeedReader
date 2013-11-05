package com.solstice.feedreader.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Set<Article> articles = new HashSet<Article>();

	public Category(String name) {
		this.name = name;
	}

	public void addArticle(Article article) {
		articles.add(article);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
