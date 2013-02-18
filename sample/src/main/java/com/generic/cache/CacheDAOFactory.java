package com.generic.cache;

import java.util.Properties;


public class CacheDAOFactory {

	private static Properties config = new Properties();
	private static CacheDAO cacheDAO = null;
	static {
		try {
			config.load(config.getClass().getClassLoader().getResourceAsStream("config.properties"));
			String cachingDaoClassName = config.getProperty("cache.dao");
		    System.out.println("instantiating caching DAO " + cachingDaoClassName);
			cacheDAO = (CacheDAO)Class.forName(cachingDaoClassName).newInstance();
		} catch (Exception e) {
			System.err.println("Exception creating CacheDAO");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static CacheDAO getCacheDAO() {
		return cacheDAO; 
	}
  
}
