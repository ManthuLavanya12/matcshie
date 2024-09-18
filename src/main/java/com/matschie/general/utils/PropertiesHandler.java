package com.matschie.general.utils;

	
	import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
	import java.io.FileInputStream;
	import java.io.IOException;

	public class PropertiesHandler {
		private static Properties prop;
		public static String config(String key )

		{
				 prop=new Properties();
					String value=null;
try {
		prop.load(new FileInputStream(new File("src/test/resources/resources/config.properties")));
		
			value=prop.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;



		}
		
		public static Map<String,String> queryparams()

		{
				 prop=new Properties();
				Map<String,String> queryparam=new HashMap<String,String>();
				
try {
		prop.load(new FileInputStream(new File("src/main/resources/queryparams/queryparams.properties")));
		for(String key : prop.stringPropertyNames()){
			//if(key.equals(querykey)) {
				queryparam.put(key, prop.getProperty(key));
				//break;
			//}
			
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryparam;



		}

		public static Map<String,String> queryparamsmap(String[] query)

		{
				 prop=new Properties();
				Map<String,String> queryparam=new HashMap<String,String>();
				
try {
		prop.load(new FileInputStream(new File("src/main/resources/queryparams/queryparams.properties")));
		for(String key : prop.stringPropertyNames()){
			for(String querykey: query) {
			if(key.equals(querykey)) {
				queryparam.put(key, prop.getProperty(querykey));
				break;
			}
			}
			
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryparam;



		}



	
	}
