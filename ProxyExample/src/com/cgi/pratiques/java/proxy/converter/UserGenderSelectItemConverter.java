package com.cgi.pratiques.java.proxy.converter;

import com.cgi.pratiques.java.proxy.entity.UserGender;
import com.cgi.pratiques.java.proxy.selectitem.SelectItem;

/**
 * To respect the Single Responsibily Principle, this class does the conversion
 * of the entity retrieved from the database to a SelectItem.
 * 
 * This is not a necessity, but would make the proxy class a little bit smaller
 * and easier to read.
 * 
 * @author Sylvain Cloutier
 */
public class UserGenderSelectItemConverter implements SelectItemConverter<UserGender> {
	public SelectItem convert(UserGender gender) {
		return new SelectItem(
				gender.getId(), 
				gender.getDescription());
	}
}
