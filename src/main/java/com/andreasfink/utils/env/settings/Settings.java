package com.andreasfink.utils.env.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.base.Preconditions;

/**
 * @author af@andreasfink.com
 *
 */
public class Settings {
	
	public static String getFromEnvOrSysProp(final String key) {
		final String fromEnv     = System.getenv(key);
		final String fromSysProp = System.getProperty(key);
		
		return (null == fromSysProp)
			? fromEnv
			: fromSysProp;
	}
	
	public static Properties loadProperties(final String fileName) {
		final InputStream is = Settings.class.getResourceAsStream(fileName);
		final Properties props;
		try {
			props = loadProperties(is);
		} catch (final Exception e) {
			throw new RuntimeException(String.format("could not load %s", fileName), e);
		}
		
		return props;
	}
	
	public static Properties loadProperties(final File propertiesFile) {
		Preconditions.checkArgument(propertiesFile.exists(), "Properties file '%s' does not exist", propertiesFile.getAbsolutePath());
		
		try {
			final FileInputStream fis;
			fis = new FileInputStream(propertiesFile);
			
			final Properties props = loadProperties(fis);
			
			return props;
		} catch(final Exception e) {
			throw new RuntimeException(String.format("could not load %s", propertiesFile.getAbsolutePath()), e);
		}
	}
	
	private static Properties loadProperties(final InputStream is) throws Exception {
		final Properties props = new Properties();
		props.load(is);
		
		return props;
	}

}
