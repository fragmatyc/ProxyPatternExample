package com.cgi.pratiques.java.proxy.selectitem;

/**
 * Just to have a kind of a SelectItem object.
 * 
 * @author Sylvain Cloutier
 */
public final class SelectItem {
	private final Object key;
	private final Object value;
	
	public SelectItem(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "SelectItem { key: \"" + this.key + "\", value: \"" + this.value + "\" }";
	}
	
	
}
