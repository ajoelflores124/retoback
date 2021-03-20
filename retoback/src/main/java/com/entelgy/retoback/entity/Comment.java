package com.entelgy.retoback.entity;

import java.io.Serializable;

public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long postID;
    private long id;
    private String name;
    private String email;
    private String body;
    
	public long getPostID() {
		return postID;
	}
	public void setPostID(long postID) {
		this.postID = postID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
    
    
    

}
