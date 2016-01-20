package com.cgi.pratiques.java.proxy.proxy;

import java.util.LinkedList;
import java.util.List;

import com.cgi.pratiques.java.proxy.converter.SelectItemConverterFactory;
import com.cgi.pratiques.java.proxy.entity.UserGender;
import com.cgi.pratiques.java.proxy.selectitem.SelectItem;
import com.cgi.pratiques.java.proxy.service.CodeTableService;

/**
 * Implementation of the proxy pattern. This class is responsible for
 * the lazy loading of the select items.
 * 
 * @author Sylvain Cloutier
 */
public class CodeTableHandlerProxy implements CodeTableHandler {
	private CodeTableHandlerImpl realSubject = new CodeTableHandlerImpl();
	private CodeTableService service = new CodeTableService();
	
	@Override
	public void setUserGenderDropList(List<SelectItem> newList) {
		// Simply delegate the call to the real subject
		this.realSubject.setUserGenderDropList(newList);
	}
	
	@Override
	public List<SelectItem> getUserGenderDropList() {
		List<SelectItem> returnedValue = this.realSubject.getUserGenderDropList();
		
		// Lazy Loading
		if (returnedValue == null) {
			returnedValue = this.loadUserGendersFromDataStore();
		} else {
			System.out.println("Cache hit for UserGender. Returning instance...");
		}
		
		return returnedValue;
	}

	private List<SelectItem> loadUserGendersFromDataStore() {
		List<SelectItem> returnedValue;
		System.out.println("UserGender not found in cache. Initializing...");
		
		returnedValue = new LinkedList<>();
		List<UserGender> genders = this.service.getUserGenders();
		
		// Proceed to convert from Entity to SelectItem
		for (UserGender currentGender : genders) {
			SelectItem convertedGender = SelectItemConverterFactory.getInstance()
					.getConverterInstance(UserGender.class)
					.convert(currentGender);
			
			returnedValue.add(convertedGender);
		}
		
		this.realSubject.setUserGenderDropList(returnedValue);
		return returnedValue;
	}

}
