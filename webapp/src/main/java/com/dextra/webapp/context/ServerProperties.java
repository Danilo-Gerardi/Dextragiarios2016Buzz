package com.dextra.webapp.context;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerProperties {

	static Logger logger = LoggerFactory.getLogger(ServerProperties.class);

	private static final String NAME = "webapp.properties";
	private static final ServerProperties SINGLETON = new ServerProperties();

	private final Properties properties;

	private ServerProperties() {
		this.properties = new Properties();
		try {
			this.properties.load(this.getClass().getClassLoader().getResourceAsStream(NAME));
		} catch (Exception e) {
			logger.error("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", e);
			throw new RuntimeException(e);
		}
	}

	public static String property(String name) {
		return SINGLETON.properties.getProperty(name);
	}

}
