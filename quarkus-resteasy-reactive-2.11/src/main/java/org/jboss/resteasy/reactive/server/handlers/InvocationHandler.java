package org.jboss.resteasy.reactive.server.handlers;

import java.util.HashMap;

import org.jboss.resteasy.reactive.server.core.ResteasyReactiveRequestContext;
import org.jboss.resteasy.reactive.server.mapping.RuntimeResource;
import org.jboss.resteasy.reactive.server.spi.EndpointInvoker;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.quarkus.resteasy.reactive.Utils;

@Weave
public class InvocationHandler {
	private final EndpointInvoker invoker = Weaver.callOriginal();
	
	@Trace(dispatcher = true)
	public void handle(ResteasyReactiveRequestContext requestContext) {
		HashMap<String, Object> attributes = new HashMap<>();
		RuntimeResource target = requestContext.getTarget();
		
		Utils.addRuntimeResource(attributes, target);
		Utils.addRequestContext(attributes, requestContext);
		Utils.addAttribute(attributes, "Invoker", invoker);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		Utils.setTransactionName(target);		
		
		Weaver.callOriginal();
	}

}
