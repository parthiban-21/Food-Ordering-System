package com.chainsys.foodorderproject.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemInCartException extends Exception{

	private static final long serialVersionUID = 1L;

	public ItemInCartException() {
		Logger logger = LoggerFactory.getLogger(ItemNotFoundException.class);
		logger.error("Item Already Available in Cart");
	}
}
