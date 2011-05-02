package com.andreasfink.utils.env.settings;

/**
 * @author af@andreasfink.com
 *
 */
public abstract class BaseSetting {
	
	private final String _key;
	
	public BaseSetting(final String key) {
		_key = key;
	}
	
	public String key() {
		return _key;
	}

}
