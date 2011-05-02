package com.andreasfink.utils.env.settings;

/**
 * 
 * @author af@andreasfink.com
 *
 */
public interface Setting<T> {
	
	public String key();
	
	public T value();
	
	public T value(final T dflt);
	
	public void set(final T value);
	
	class StringSetting extends BaseSetting implements Setting<String> {
		
		public StringSetting(final String key) {
			super(key);
		}

		@Override public String value() {
			return System.getProperty(key());
		}

		@Override public String value(final String dflt) {
			return System.getProperty(key(), dflt);
		}

		@Override public void set(final String value) {
			System.setProperty(key(), value);
		}
		
	}
	
	class BooleanSetting extends BaseSetting implements Setting<Boolean> {
		
		public BooleanSetting(final String key) {
			super(key);
		}

		@Override public Boolean value() {
			final String prop = System.getProperty(key());
			final Boolean parsedProp = Boolean.parseBoolean(prop);
			
			return parsedProp;
		}

		@Override public Boolean value(final Boolean dflt) {
			final String prop = System.getProperty(key(), dflt.toString());
			final Boolean parsedProp = Boolean.parseBoolean(prop);
			
			return parsedProp;
		}

		@Override public void set(final Boolean value) {
			System.setProperty(key(), value.toString());
		}
		
	}

	class IntegerSetting extends BaseSetting implements Setting<Integer> {
	
		public IntegerSetting(final String key) {
			super(key);
		}
	
		@Override public Integer value() {
			final String prop = System.getProperty(key());
			final Integer parsedProp = Integer.parseInt(prop);
			
			return parsedProp;
		}
	
		@Override public Integer value(final Integer dflt) {
			final String prop = System.getProperty(key(), dflt.toString());
			final Integer parsedProp = Integer.parseInt(prop);
			
			return parsedProp;
		}
	
		@Override public void set(final Integer value) {
			System.setProperty(key(), value.toString());
		}
	
	}

}
