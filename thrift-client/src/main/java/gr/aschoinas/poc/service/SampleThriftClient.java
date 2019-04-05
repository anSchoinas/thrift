package gr.aschoinas.poc.service;

import gr.aschoinas.generated.SampleService;
import org.apache.http.impl.client.HttpClients;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Andreas Schoinas on 25/7/2018
 */
public class SampleThriftClient extends SampleService.Client {

	public SampleThriftClient(TProtocolFactory tProtocolFactory) throws TTransportException {
		super(tProtocolFactory.getProtocol(new THttpClient("http://localhost:8000/thrift", HttpClients.createDefault())));
	}
}
