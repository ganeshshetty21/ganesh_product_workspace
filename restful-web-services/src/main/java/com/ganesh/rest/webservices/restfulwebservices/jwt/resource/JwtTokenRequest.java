package com.ganesh.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJHYW5lc2giLCJleHAiOjE1OTMyMTk2MTYsImlhdCI6MTU5MjYxNDgxNn0.1hiZDz60U8tZSTiZ9pdL6ljnMSft4c89xwHCb6SW1WMj5h2L3KHqNzIzXrYwShQ0c5HsNnqBdHIQw38-Y1xUzg"
//    }

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
