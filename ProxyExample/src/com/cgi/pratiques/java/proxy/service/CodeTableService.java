package com.cgi.pratiques.java.proxy.service;

import java.util.Arrays;
import java.util.List;

import com.cgi.pratiques.java.proxy.entity.UserGender;

/**
 * Dummy Service class to emulate how the objects are actually retrieved
 * from the database.
 * @author closy2
 */
public class CodeTableService {
	public List<UserGender> getUserGenders() {
		this.simulateDatabaseLatency();
		return Arrays.asList(new UserGender[] {
				 new UserGender("M", "Male"),
				 new UserGender("F", "Female"),
				 new UserGender("U", "Unknown")});
	}

	private void simulateDatabaseLatency() {
		try {
			System.out.println("Executing query: SELECT * FROM USER_GENDERS");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
