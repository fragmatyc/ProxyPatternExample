package com.cgi.pratiques.java.proxy.entity;

/**
 * Simply an entity on which we will have a dropdown list.
 * 
 * @author Sylvain Cloutier
 */
public final class UserGender {
	private final String id;
	private final String description;
	
	public UserGender(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
}
