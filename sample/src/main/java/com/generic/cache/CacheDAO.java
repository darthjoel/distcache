package com.generic.cache;


public interface CacheDAO {
  
  public void setAttribute(String name, Object obj) ;
  public Object getAttribute(String name) ;
}
