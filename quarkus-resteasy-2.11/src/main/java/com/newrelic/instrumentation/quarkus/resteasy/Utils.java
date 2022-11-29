package com.newrelic.instrumentation.quarkus.resteasy;

import java.util.Map;

import io.vertx.ext.web.Route;

public class Utils {

	public static final String NEWRELIC_TOKEN = "NewRelic-Token";
	
	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(attributes != null && key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	public static void addRoute(Map<String, Object> attributes, Route route) {
		if(route != null) {
			addAttribute(attributes, "Route-Name", route.getName());
			addAttribute(attributes, "Route-Path", route.getPath());
		}
	}
}
