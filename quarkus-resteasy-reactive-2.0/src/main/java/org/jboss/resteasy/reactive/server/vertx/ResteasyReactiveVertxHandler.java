package org.jboss.resteasy.reactive.server.vertx;

import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.quarkus.resteasy.reactive.Utils;

import io.vertx.ext.web.RoutingContext;

@Weave
public abstract class ResteasyReactiveVertxHandler {

    @Trace
    public void handle(RoutingContext event) {
	HashMap<String, Object> attributes = new HashMap<String, Object>();
	Utils.addAttribute(attributes, "RoutingContext-NormalizedPath", event.normalizedPath());
	Utils.addRoute(attributes, event.currentRoute());
	NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
	Utils.setTransactionName(event);
	Weaver.callOriginal();
    }
}
