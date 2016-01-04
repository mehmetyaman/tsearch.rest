package com.edia.tsearch.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * just a simple pojo for texture domain object 
 * 
 * @author mehmetyaman
 *
 */
@XmlRootElement
public class Texture {

	private String title;
	private String content;
	
	public Texture() {
		super();
	}
	
	public Texture(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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
	
}
