package io.quarkus.resteasy.reactive.server.runtime.filters;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.server.spi.ResteasyReactiveContainerRequestContext;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.smallrye.mutiny.Uni;

@Weave
public class FilterUtil {

	@Trace
	public static void handleOptional(Optional<Response> optional, ResteasyReactiveContainerRequestContext context) {
		Weaver.callOriginal();
	}
	
	@Trace
	public static void handleResponse(Response response,
            ResteasyReactiveContainerRequestContext context) {
		Weaver.callOriginal();
	}
	
	@Trace
	public static void handleUniVoid(Uni<Void> uni, ResteasyReactiveContainerRequestContext context) {
		Weaver.callOriginal();
	}
	
	@Trace
	 public static void handleUniResponse(Uni<Response> uni, ResteasyReactiveContainerRequestContext context) {
			Weaver.callOriginal();
	 }
}
