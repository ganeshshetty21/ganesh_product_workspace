package com.ganesh.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTestMain {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LoggerTestMain.class);
		StringBuilder builder = new StringBuilder();
		String password = "secret";
		for (int i = 1; i < 16; i++) {
			logger.info(" {}", i);
			builder.append(i % 10);
			// System.out.println(" " + builder);
			logger.info(" {}", builder);
			logger.info(" Password:{}", password);
		}

	}

}
