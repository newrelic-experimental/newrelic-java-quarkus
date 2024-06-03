package io.quarkus.resteasy.runtime.standalone;

import java.io.InputStream;
import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.quarkus.resteasy.Utils;

import io.vertx.ext.web.RoutingContext;

@Weave
public class VertxRequestHandler {

    @Trace
    public void handle(RoutingContext request) {
	HashMap<String, Object> attributes = new HashMap<String, Object>();
	Utils.addAttribute(attributes, "RoutingContext-NormalizedPath", request.normalizedPath());
	Utils.addRoute(attributes, request.currentRoute());
	NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
	Utils.setTransactionName(request);
	Weaver.callOriginal();
    }

    @Trace
    private void dispatch(RoutingContext routingContext, InputStream is, VertxOutput output) {
	HashMap<String, Object> attributes = new HashMap<String, Object>();
	Utils.addAttribute(attributes, "RoutingContext-NormalizedPath", routingContext.normalizedPath());
	Utils.addRoute(attributes, routingContext.currentRoute());
	NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);

	Weaver.callOriginal();
    }

}
