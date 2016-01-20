package com.cgi.pratiques.java.proxy.controller;

import com.cgi.pratiques.java.proxy.proxy.CodeTableHandler;

/**
 * Demo of an Action Controller
 * This is the point of entry of the demo of the proxy pattern.
 * 
 * @author Sylvain Cloutier
 */
public class UserGenderActionCTL {
	private UserSessionCTL userSession = new UserSessionCTL();
	
	public UserSessionCTL getUserSessionCTL() {
		return userSession;
	}

	public static void main(String[] args) {
		// As a client of the proxy pattern you don't need to see which
		// implementation was returned, it should be transparent to all
		// client as we created an interface for both the proxy and the
		// actual implementation. Suppose we are in userGender.xhtml
		
		// Fake the controller creation for demo purpose, handled by Spring.
		UserGenderActionCTL userGenderActionCTL = new UserGenderActionCTL();
		
		// In the view, we would have something like:
		
		//    <p:selectOneMenu value="userGenderActionCTL.viewState.selectedGender">
		//        <f:selectItems value="userSessionCTL.codeTableHandler.userGenderDropList"/>
		//    </p:selectOneMenu>
		
		// The above piece of code won't change across the application because of the interface
		
		
		// To demonstrate, simply call it here:
		System.out.println("First call ever to the proxy");
		UserGenderActionCTL.runDemo(userGenderActionCTL);
		
		
		// Then, we call it again from another place
		System.out.println("\nAny subsequent call to the proxy");
		UserGenderActionCTL.runDemo(userGenderActionCTL);
		
		// And again...
		System.out.println("\nAny subsequent call to the proxy");
		UserGenderActionCTL.runDemo(userGenderActionCTL);
		
		// But, if we want to refresh the cache from the admin module, we do
		userGenderActionCTL.getUserSessionCTL().getCodeTableHandler()
				.setUserGenderDropList(CodeTableHandler.FORCE_REFRESH_COLLECTION);
		
		// The above code will free the "cached" SelectItem. Now, if we do
		System.out.println("\nRight after we forced the refresh, the first call to the proxy loads the data again.");
		UserGenderActionCTL.runDemo(userGenderActionCTL);
		
		// Then, we call it again from another place, just for the win!
		System.out.println("\nAny subsequent call to the proxy");
		UserGenderActionCTL.runDemo(userGenderActionCTL);
	}
	
	public static void runDemo(UserGenderActionCTL userGenderActionCTL) {
		userGenderActionCTL.getUserSessionCTL().getCodeTableHandler()
				.getUserGenderDropList().forEach(currentSelectItem -> {
			
			// Print what we got from the proxy
			System.out.println(currentSelectItem.toString());
		});
	}
}
