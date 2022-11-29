package com.newrelic.instrumentation.quarkus.resteasy;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import com.newrelic.api.agent.Token;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.Cookie;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.ParsedHeaderValues;
import io.vertx.ext.web.RequestBody;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;

@SuppressWarnings("deprecation")
public class NRRoutingContext implements RoutingContext {
	
	private RoutingContext delegate = null;
	private Token token = null;
	
	public NRRoutingContext(RoutingContext d, Token t) {
		delegate = d;
		token = t;
	}
	
	public Token getToken() {
		Token t = token;
		token = null;
		return t;
	}

	@Override
	public HttpServerRequest request() {
		return delegate.request();
	}

	@Override
	public HttpServerResponse response() {
		return delegate.response();
	}

	@Override
	public void next() {
		delegate.next();
	}

	@Override
	public void fail(int statusCode) {
		delegate.fail(statusCode);
	}

	@Override
	public void fail(Throwable throwable) {
		delegate.fail(throwable);
	}

	@Override
	public void fail(int statusCode, Throwable throwable) {
		delegate.fail(statusCode, throwable);
	}

	@Override
	public RoutingContext put(String key, Object obj) {
		return delegate.put(key, obj);
	}

	@Override
	public <T> T get(String key) {
		return delegate.get(key);
	}

	@Override
	public <T> T get(String key, T defaultValue) {
		return delegate.get(key,defaultValue);
	}

	@Override
	public <T> T remove(String key) {
		return delegate.remove(key);
	}

	@Override
	public Map<String, Object> data() {
		return delegate.data();
	}

	@Override
	public Vertx vertx() {
		return delegate.vertx();
	}

	@Override
	public String mountPoint() {
		return delegate.mountPoint();
	}

	@Override
	public Route currentRoute() {
		return delegate.currentRoute();
	}

	@Override
	public String normalizedPath() {
		return delegate.normalizedPath();
	}

	@Override
	public Cookie getCookie(String name) {
		return delegate.getCookie(name);
	}

	@Override
	public RoutingContext addCookie(Cookie cookie) {
		return delegate.addCookie(cookie);
	}

	@Override
	public Cookie removeCookie(String name, boolean invalidate) {
		return delegate.removeCookie(name, invalidate);
	}

	@Override
	public int cookieCount() {
		return delegate.cookieCount();
	}

	@Override
	public Map<String, Cookie> cookieMap() {
		return delegate.cookieMap();
	}

	@Override
	public String getBodyAsString() {
		return delegate.getBodyAsString();
	}

	@Override
	public String getBodyAsString(String encoding) {
		return delegate.getBodyAsString(encoding);
	}

	@Override
	public JsonObject getBodyAsJson(int maxAllowedLength) {
		return delegate.getBodyAsJson(maxAllowedLength);
	}

	@Override
	public JsonArray getBodyAsJsonArray(int maxAllowedLength) {
		return delegate.getBodyAsJsonArray(maxAllowedLength);
	}

	@Override
	public Buffer getBody() {
		return delegate.getBody();
	}

	@Override
	public List<FileUpload> fileUploads() {
		return delegate.fileUploads();
	}

	@Override
	public Session session() {
		return delegate.session();
	}

	@Override
	public boolean isSessionAccessed() {
		return delegate.isSessionAccessed();
	}

	@Override
	public User user() {
		return delegate.user();
	}

	@Override
	public Throwable failure() {
		return delegate.failure();
	}

	@Override
	public int statusCode() {
		return delegate.statusCode();
	}

	@Override
	public String getAcceptableContentType() {
		return delegate.getAcceptableContentType();
	}

	@Override
	public ParsedHeaderValues parsedHeaders() {
		return delegate.parsedHeaders();
	}

	@Override
	public int addHeadersEndHandler(Handler<Void> handler) {
		return delegate.addHeadersEndHandler(handler);
	}

	@Override
	public boolean removeHeadersEndHandler(int handlerID) {
		return delegate.removeHeadersEndHandler(handlerID);
	}

	@Override
	public int addBodyEndHandler(Handler<Void> handler) {
		return delegate.addBodyEndHandler(handler);
	}

	@Override
	public boolean removeBodyEndHandler(int handlerID) {
		return delegate.removeBodyEndHandler(handlerID);
	}

	@Override
	public int addEndHandler(Handler<AsyncResult<Void>> handler) {
		return delegate.addEndHandler(handler);
	}

	@Override
	public boolean removeEndHandler(int handlerID) {
		return delegate.removeEndHandler(handlerID);
	}

	@Override
	public boolean failed() {
		return delegate.failed();
	}

	@Override
	public void setBody(Buffer body) {
		delegate.setBody(body);
	}

	@Override
	public void setSession(Session session) {
		delegate.setSession(session);	
	}

	@Override
	public void setUser(User user) {
		delegate.setUser(user);	
	}

	@Override
	public void clearUser() {
		delegate.clearUser();	
	}

	@Override
	public void setAcceptableContentType(String contentType) {
		delegate.setAcceptableContentType(contentType);
	}

	@Override
	public void reroute(HttpMethod method, String path) {
		delegate.reroute(method, path);
	}

	@Override
	public Map<String, String> pathParams() {
		return delegate.pathParams();
	}

	@Override
	public String pathParam(String name) {
		return delegate.pathParam(name);
	}

	@Override
	public MultiMap queryParams() {
		return delegate.queryParams();
	}

	@Override
	public MultiMap queryParams(Charset encoding) {
		return delegate.queryParams(encoding);
	}

	@Override
	public List<String> queryParam(String name) {
		return delegate.queryParam(name);
	}

	@Override
	public RequestBody body() {
		return delegate.body();
	}


}
