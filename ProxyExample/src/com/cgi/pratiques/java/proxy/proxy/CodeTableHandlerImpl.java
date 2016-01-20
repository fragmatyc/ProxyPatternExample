package com.cgi.pratiques.java.proxy.proxy;

import java.util.List;

import com.cgi.pratiques.java.proxy.selectitem.SelectItem;

/**
 * CodeTableHandlerImpl
 * Now simply a holder for all drop list values, a kind of "cache".
 * 
 * @author Sylvain Cloutier
 */
public class CodeTableHandlerImpl implements CodeTableHandler {
	private List<SelectItem> userGenderDropList;
	
	@Override
	public List<SelectItem> getUserGenderDropList() {
		return this.userGenderDropList;
	}

	public void setUserGenderDropList(List<SelectItem> userGenderDropList) {
		this.userGenderDropList = userGenderDropList;
	}
	
}
