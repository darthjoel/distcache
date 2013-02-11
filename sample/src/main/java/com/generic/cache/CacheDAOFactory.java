package com.generic.cache;


public class CacheDAOFactory {

	public static CacheDAO getCacheDAO (){
		return GemfireDAO.getDAO();
	}
  
}
