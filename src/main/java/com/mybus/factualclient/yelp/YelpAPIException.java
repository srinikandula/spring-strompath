package com.mybus.factualclient.yelp;

public class YelpAPIException extends Exception {
	
	private static final long serialVersionUID = -4581357612541474483L;

	  /**
	   * Constructor
	   * 
	   * @param message message
	   */
	  public YelpAPIException(String message) {
	    super(message);
	  }
	  
	  /**
	   * Constructor
	   * 
	   * @param t throwable
	   */
	  public YelpAPIException(Throwable t) {
	    super(t);
	  }

}
