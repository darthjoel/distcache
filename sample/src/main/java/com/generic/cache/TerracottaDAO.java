package com.generic.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class TerracottaDAO implements CacheDAO {

	private static final CacheManager  cacheManager  = new CacheManager();
	
	public void setAttribute(String name, Object obj) {
		System.out.println("TerracottaDAO: setAttribute " + name);
		getCache().put(new Element(name, obj));
	}

	public Object getAttribute(String name) {
		System.out.println("TerracottaDAO: getAttribute " + name);
	    Element elem = getCache().get(name);
	    if (elem != null) {
	      return elem.getObjectValue();
	    }
	    return null;
	}
	
	private Ehcache getCache() {
	    return cacheManager.getEhcache("catalog");
	  }

}
