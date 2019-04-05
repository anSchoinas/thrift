package gr.aschoinas.poc.service;

import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Andreas Schoinas on 4/4/2019
 */
@Service
public class SampleThriftClientPool {
	private static int MAX_CONNECTIONS = 40;
	private BlockingQueue<SampleThriftClient> clients;
	private TProtocolFactory protocolFactory;

	public SampleThriftClientPool(TProtocolFactory tProtocolFactory) {
		this.protocolFactory = tProtocolFactory;
		init();
	}

	private void init() {
		clients = new LinkedBlockingDeque<>(MAX_CONNECTIONS);
		for (int i = 0; i < MAX_CONNECTIONS; i++) {
			try {
				clients.add(new SampleThriftClient(protocolFactory));
			} catch (TTransportException tte) {
				tte.printStackTrace();
			}
		}
	}

	public SampleThriftClient getClient() {
		try {
			return clients.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void release(SampleThriftClient client){
		if (client != null){
			clients.offer(client);
		}
	}
}