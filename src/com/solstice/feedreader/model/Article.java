package com.solstice.feedreader.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Article  implements Serializable{
	
	private String title;
	private String content;
	
	private Set<String> categoryNames = new HashSet<String>();
	private String authorName;
	
	public void addCategory(String categoryName) {
		categoryNames.add(categoryName);
	}
	
	public Iterable<String> getCategoryNames() {
		return categoryNames;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
