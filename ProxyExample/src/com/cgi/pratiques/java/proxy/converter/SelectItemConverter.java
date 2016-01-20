package com.cgi.pratiques.java.proxy.converter;

import com.cgi.pratiques.java.proxy.selectitem.SelectItem;

/**
 * Abstraction of a converter to be used by the {@link SelectItemConverterFactory}
 * @author Sylvain Cloutier
 */
public interface SelectItemConverter<T> {
	public abstract SelectItem convert(T entity);
}
