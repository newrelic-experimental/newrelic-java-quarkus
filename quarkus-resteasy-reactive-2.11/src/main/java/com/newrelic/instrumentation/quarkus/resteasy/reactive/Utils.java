package com.newrelic.instrumentation.quarkus.resteasy.reactive;

import java.util.Map;
import java.util.logging.Level;

import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.reactive.server.core.ResteasyReactiveRequestContext;
import org.jboss.resteasy.reactive.server.mapping.RuntimeResource;
import org.jboss.resteasy.reactive.server.mapping.URITemplate;

import com.newrelic.api.agent.Logger;
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

    public static void addRuntimeResource(Map<String, Object> attributes, RuntimeResource resource) {
	if (resource != null) {
	    Logger logger = NewRelic.getAgent().getLogger();
	    addAttribute(attributes, "RuntimeResource-HttpMethod", resource.getHttpMethod());
	    logger.log(Level.FINE, "adding RuntimeResource-HttpMethod: {0}", resource.getHttpMethod());
	    addAttribute(attributes, "RuntimeResource-JavaMethodName", resource.getJavaMethodName());
	    logger.log(Level.FINE, "adding RuntimeResource-JavaMethodName: {0}", resource.getJavaMethodName());
	    URITemplate template = resource.getPath();
	    logger.log(Level.FINE, "adding RuntimeResource-Path: {0}", resource.getPath());
	    addAttribute(attributes, "RuntimeResource-Path", template != null ? template.toString() : "null");
	    template = resource.getClassPath();
	    logger.log(Level.FINE, "adding RuntimeResource-ClassPath: {0}", resource.getClassPath());
	    addAttribute(attributes, "RuntimeResource-ClassPath", template != null ? template.toString() : "null");

	}
    }

    public static void addRequestContext(Map<String, Object> attributes, ResteasyReactiveRequestContext context) {
	if (context != null) {
	    addAttribute(attributes, "ResteasyReactiveRequestContext-AbsoluteURI", context.getAbsoluteURI());
	    addAttribute(attributes, "ResteasyReactiveRequestContext-Method", context.getMethod());
	    addAttribute(attributes, "ResteasyReactiveRequestContext-Path", context.getPath());
	    UriInfo uriInfo = context.getUriInfo();
	    addUriInfo(attributes, uriInfo);
	}
    }

    public static void addUriInfo(Map<String, Object> attributes, UriInfo info) {
	if (info != null) {
	    addAttribute(attributes, "UriInfo-Path", info.getPath());
	    addAttribute(attributes, "UriInfo-BaseUri", info.getBaseUri());
	    addAttribute(attributes, "UriInfo-MatchedURIs", info.getMatchedURIs());
	    addAttribute(attributes, "UriInfo-PathSegments", info.getPathSegments());
	}
    }

    public static void addRoute(Map<String, Object> attributes, Route route) {
	if (route != null) {
	    addAttribute(attributes, "Route-Name", route.getName());
	    addAttribute(attributes, "Route-Path", route.getPath());
	}
    }

    public static void setTransactionName(Map<String, Object> attributes, Route route) {
	if (route != null) {
	    addAttribute(attributes, "Route-Name", route.getName());
	    addAttribute(attributes, "Route-Path", route.getPath());
	}
    }

    public static void setTransactionName(RuntimeResource resource) {
	if (resource != null) {
	    URITemplate path = resource.getPath();
	    URITemplate classpath = resource.getClassPath();

	    String method = resource.getHttpMethod();

	    StringBuffer sb = new StringBuffer();

	    if (method != null & method.length() > 0) {
		sb.append("(" + method + ") ");
	    }

	    if (classpath != null) {
		String template = classpath.template;
		if (template != null && !template.isEmpty()) {
		    sb.append(template);
		}
	    }
	    if (path != null) {
		String template = path.template;
		if (template != null && !template.isEmpty()) {
		    sb.append(template);
		}
	    }

	    if (sb.length() > 0) {
		NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.CUSTOM_LOW, true,
			"Quarkus-Resteasy", sb.toString());
	    }
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
		"resteasy-reactive", name);

    }
}
