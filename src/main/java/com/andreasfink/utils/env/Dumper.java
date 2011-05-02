package com.andreasfink.utils.env;

import java.io.OutputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * @author af@andreasfink.com
 *
 */
public class Dumper {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final SerializationConfig sc = mapper.getSerializationConfig();
	
	private Dumper() {}
	
	static {
		sc.setSerializationInclusion(Inclusion.ALWAYS);
		
		sc.enable(Feature.INDENT_OUTPUT);
		sc.enable(Feature.WRITE_NULL_MAP_VALUES);
		sc.enable(Feature.AUTO_DETECT_GETTERS);
		sc.enable(Feature.AUTO_DETECT_IS_GETTERS);
		sc.enable(Feature.AUTO_DETECT_FIELDS);
		
		sc.disable(Feature.FAIL_ON_EMPTY_BEANS);
		sc.disable(Feature.WRITE_DATES_AS_TIMESTAMPS);
		sc.disable(Feature.CLOSE_CLOSEABLE);
	}
	
	public static void dump(final Object obj) {
		dump(obj, System.out, mapper);
	}
	
	public static void dump(final Object obj, final OutputStream out) {
		dump(obj, out, mapper);
	}
	
	private static void dump(final Object obj, final OutputStream out, final ObjectMapper mapper) {
		try {
			mapper.writeValue(out, obj);
		} catch (final Exception e) {
			throw new RuntimeException("Could not dump Object", e);
		}
	}
	
}
