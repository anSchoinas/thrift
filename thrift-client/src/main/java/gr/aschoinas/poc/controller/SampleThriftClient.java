package gr.aschoinas.poc.controller;

import gr.aschoinas.generated.SampleService;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Andreas Schoinas on 25/7/2018
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SampleThriftClient extends SampleService.Client {

	public SampleThriftClient(TProtocolFactory tProtocolFactory) throws TTransportException {
		super(tProtocolFactory.getProtocol(new THttpClient("http://localhost:8000/thrift")));
	}
}
