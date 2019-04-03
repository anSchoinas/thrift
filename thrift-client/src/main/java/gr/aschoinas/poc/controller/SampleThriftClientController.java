package gr.aschoinas.poc.controller;

import gr.aschoinas.generated.SampleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by Andreas Schoinas on 25/7/2018
 */
@RestController
public class SampleThriftClientController {

	@Autowired
	private SampleThriftClient client;

	@RequestMapping("thrift/test")
	public String testThrift(final SampleRequest request) {
		try {
			return client.sampleMethod(request);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
