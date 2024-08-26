package io.quarkus.vertx.runtime;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.vertx.core.eventbus.Message;

@Weave(type = MatchType.BaseClass)
public abstract class EventConsumerInvoker {

	@Trace(dispatcher = true)
	public void invoke(Message<Object> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","EventConsumerInvoker","invoke");
		Weaver.callOriginal();
	}
	
	protected Object invokeBean(Message<Object> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","EventConsumerInvoker",getClass().getSimpleName(),"invokeBean");
		return Weaver.callOriginal();
	}
}
