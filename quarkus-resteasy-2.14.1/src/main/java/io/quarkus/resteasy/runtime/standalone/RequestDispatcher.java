package io.quarkus.resteasy.runtime.standalone;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import io.vertx.core.Context;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

@Weave
public abstract class RequestDispatcher {

    @Trace
    public void service(Context context, HttpServerRequest req, HttpServerResponse resp, HttpRequest vertxReq,
	    HttpResponse vertxResp, boolean handleNotFound, Throwable t) {
	if (t != null) {
	    NewRelic.noticeError(t);
	}

	Weaver.callOriginal();
    }
}
