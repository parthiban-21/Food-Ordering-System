package com.chainsys.foodorderproject.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderIDNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OrderIDNotFoundException() {
		Logger logger = LoggerFactory.getLogger(ItemNotFoundException.class);
		logger.error("OrderID Not Found");
	}
}
