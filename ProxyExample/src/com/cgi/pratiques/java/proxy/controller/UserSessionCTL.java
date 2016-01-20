package com.cgi.pratiques.java.proxy.controller;

import com.cgi.pratiques.java.proxy.proxy.CodeTableHandler;
import com.cgi.pratiques.java.proxy.proxy.CodeTableHandlerProxy;

/**
 * Emulation of the UserSessionCTL.
 * @author closy2
 */
public class UserSessionCTL {
	private CodeTableHandler codeTableHandler;

	public UserSessionCTL() {
		this.codeTableHandler = new CodeTableHandlerProxy();
	}
	
	public CodeTableHandler getCodeTableHandler() {
		return codeTableHandler;
	}

}
