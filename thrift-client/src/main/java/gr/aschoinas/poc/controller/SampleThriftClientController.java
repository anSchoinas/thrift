package gr.aschoinas.poc.controller;

import gr.aschoinas.generated.SampleRequest;
import gr.aschoinas.poc.service.SampleThriftClient;
import gr.aschoinas.poc.service.SampleThriftClientPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Andreas Schoinas on 25/7/2018
 */
@RestController
public class SampleThriftClientController {

	private BufferedWriter writer;

	@Autowired
	private SampleThriftClientPool clientPool;


	@RequestMapping("thrift/test")
	public String testThrift(SampleRequest request) {
		SampleThriftClient client = null;
		try {
			client = clientPool.getClient();
			String response = client.sampleMethod(request);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}finally {
			clientPool.release(client);
		}
	}
}
