package gr.aschoinas.thrift;

import gr.aschoinas.generated.SampleRequest;
import gr.aschoinas.generated.SampleService;
import org.apache.thrift.TException;

/**
 * Created by Andreas Schoinas on 2/4/2019
 */
public class SampleServiceControllerHandler implements SampleService.Iface {

	@Override
	public String sampleMethod(SampleRequest request) throws TException {
		String name = request.getName() + " " + (request.getMiddleName() == null ? "" : request.getMiddleName()) + " "
				+ request.getLastname();
		return "Your name is: " + name + ". Your age is: " + request.getAge();
	}

}
