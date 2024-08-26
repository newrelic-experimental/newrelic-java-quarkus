package org.jboss.resteasy.reactive.server.spi;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public abstract class EndpointInvoker {

	@Trace(dispatcher = true)
	public Object invoke(Object instance, Object[] parameters)  {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","Resteasy","Reactive","EndpointInvoker",getClass().getName(),"invoke");
		return Weaver.callOriginal();
	}
}
