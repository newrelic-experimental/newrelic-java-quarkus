package com.newrelic.instrumentation.quarkus.resteasy;

import java.util.Map;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.TransactionNamePriority;

import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;

public class Utils {

    public static final String NEWRELIC_TOKEN = "NewRelic-Token";

    public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
	if (attributes != null && key != null && !key.isEmpty() && value != null) {
	    attributes.put(key, value);
	}
    }

    public static void addRoute(Map<String, Object> attributes, Route route) {
	if (route != null) {
	    addAttribute(attributes, "Route-Name", route.getName());
	    addAttribute(attributes, "Route-Path", route.getPath());
	}
    }

    public static void setTransactionName(RoutingContext request) {
	String name = " ";
	String route = request.currentRoute().getName();
	if (route != null & route.length() > 0) {
	    name += route;
	}
	String path = request.currentRoute().getPath();
	if (path != null & path.length() > 0) {
	    name += ":" + path;
	}
	String method = request.request().method().name();
	if (method != null & method.length() > 0) {
	    name += " (" + method + ")";
	}
	NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_LOW, false, "Quarkus",
		"resteasy", name);

    }
}
