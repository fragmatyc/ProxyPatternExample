package com.cgi.pratiques.java.proxy.converter;

import java.util.HashMap;
import java.util.Map;

import com.cgi.pratiques.java.proxy.entity.UserGender;

/**
 * Because we have tons of entities and we need a converter per entity,
 * this is to simplify the usage of the converters. Again, this is simply
 * an easy idea to reduce the size of the code table handler proxy.
 * 
 * @author Sylvain Cloutier
 */
public class SelectItemConverterFactory {
	private static SelectItemConverterFactory instance = null;
	
	private Map<Class<? extends Object>, SelectItemConverter<? extends Object>> converterCache = new HashMap<>();
	
	private SelectItemConverterFactory() {}
	
	/**
	 * For Singleton purpose, not necessary with Spring ;)
	 */
	public static SelectItemConverterFactory getInstance() {
		return (instance == null ? 
				instance = new SelectItemConverterFactory() : instance);
	}
	
	/**
	 * Will build the converter instance if necessary
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> SelectItemConverter<T> getConverterInstance(Class<T> entityClass) {
		SelectItemConverter constructedConverter = this.converterCache.get(entityClass);
		
		if (constructedConverter == null) {
			constructedConverter = this.makeNewConverterInstance(entityClass);
		}
		
		return constructedConverter;
	}

	@SuppressWarnings({ "rawtypes" })
	private <T> SelectItemConverter makeNewConverterInstance(Class<T> entityClass) {
		SelectItemConverter constructedConverter = null;
		
		if (UserGender.class.equals(entityClass)) {
			constructedConverter = new UserGenderSelectItemConverter();
		}
		
		return constructedConverter;
	}
	
	
}
