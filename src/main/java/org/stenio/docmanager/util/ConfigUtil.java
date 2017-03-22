/*
 * Copyright (c) 1997, 2016, 网易公司版权所有. All rights reserved. 
 */
package org.stenio.docmanager.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bjhexin3 2017年1月19日
 * @version 1.0
 *
 */
public class ConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

	private static final String CONFIG_LOCATION = "conf/config.properties";

	private static Properties props;

	static {
		init();
	}

	private static void init() {
		load();
	}

	private static synchronized void load() {
		if (props == null) { 
			InputStream in = null;
			InputStreamReader reader = null;
			try {
				in = ConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_LOCATION);
				reader = new InputStreamReader(in, "UTF-8");
				props = new Properties();
				props.load(reader);
			} catch (Exception e) {
				logger.error("read configuration file error, file path : {}", CONFIG_LOCATION);
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
					if (in != null) {
						in.close();
					}
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 重新加载配置文件
	 * 
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @throws IOException
	 */
	public static void reload() throws IOException {
		load();
	}

	/**
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return props.getProperty(key);
	}

	/**
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @param key
	 * @return
	 */
	public static Integer getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	/**
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @param key
	 * @return
	 */
	public static Long getLong(String key) {
		return Long.parseLong(getString(key));
	}

	/**
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @param key
	 * @return
	 */
	public static Double getDouble(String key) {
		return Double.parseDouble(getString(key));
	}

	/**
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @param key
	 * @return
	 */
	public static Float getFloat(String key) {
		return Float.parseFloat(getString(key));
	}

	/**
	 * @author bjhexin3 2016年9月7日
	 * @version 1.0
	 *
	 * @param key
	 * @return
	 */
	public static Boolean getBoolean(String key) {
		return Boolean.parseBoolean(getString(key));
	}

}
