package org.jboss.resteasy.reactive.server.filters;

import java.util.Optional;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.spi.ResteasyReactiveContainerRequestContext;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.Response;

@Weave
abstract public class FilterUtil {

    @Trace
    public static void handleOptional(Optional<Response> optional, ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

    @Trace
    public static void handleOptionalRestResponse(Optional<RestResponse<?>> optional,
	    ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

    @Trace
    public static void handleResponse(Response response, ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

    @Trace
    public static void handleRestResponse(RestResponse<?> response, ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

    @Trace
    public static void handleUniVoid(Uni<Object> uni, ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

    @Trace
    public static void handleUniResponse(Uni<Response> uni, ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

    @Trace
    public static void handleUniRestResponse(Uni<? extends RestResponse<?>> uni,
	    ResteasyReactiveContainerRequestContext context) {
	Weaver.callOriginal();
    }

}
