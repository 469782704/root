package org.spring.common.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	private PropertiesUtil(){}
	
	public static Properties getInstances(String path){
		Properties prop = new Properties();
		try {
			prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(path));
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		Properties prop = PropertiesUtil.getInstances("org/spring/common/properties/db.properties");
		String driver = prop.get("jdbc.driver").toString();
		System.out.println(driver);
	}
}
