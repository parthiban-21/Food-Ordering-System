package com.chainsys.foodorderproject.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException() {
		Logger logger = LoggerFactory.getLogger(ItemNotFoundException.class);
		logger.error("Invalid Item Name");
	}
}
