package com.cgi.pratiques.java.proxy.proxy;

import java.util.List;

import com.cgi.pratiques.java.proxy.controller.UserGenderActionCTL;
import com.cgi.pratiques.java.proxy.selectitem.SelectItem;

/**
 * Created using the Extract Interface method of refactoring. This
 * ensure that both the proxy and the actual subject will have the proper
 * getters of the drop list values.
 * 
 * @see Martin Fowler - Working effectively with legacy code
 * @see http://refactoring.com/catalog/extractInterface.html
 * 
 * @author closy2
 */
public interface CodeTableHandler {
	/**
	 * Easy way of forcing the refresh and making the code readable.
	 * @see UserGenderActionCTL
	 */
	public static final List<SelectItem> FORCE_REFRESH_COLLECTION = null;
	
	public abstract List<SelectItem> getUserGenderDropList();
	public abstract void setUserGenderDropList(List<SelectItem> newList);
}
