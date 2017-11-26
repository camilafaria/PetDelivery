package br.com.petdelivery.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HelperController {
	static String PROPERTY_FILE = System.getProperty("catalina.base")+"\\wtpwebapps\\ESI2017\\WEB-INF\\lib\\config.properties";
	
	public static String getProperty(String property) {
		Properties prop = new Properties();
		InputStream input = null;
		String value = "";
		try {
			input = new FileInputStream(PROPERTY_FILE);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			value = prop.getProperty(property);			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
