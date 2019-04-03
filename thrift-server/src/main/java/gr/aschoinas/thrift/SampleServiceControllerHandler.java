package gr.aschoinas.thrift;

import gr.aschoinas.generated.SampleRequest;
import gr.aschoinas.generated.SampleService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * Created by Andreas Schoinas on 2/4/2019
 */
@Service
public class SampleServiceControllerHandler implements SampleService.Iface {

	@Override
	public String sampleMethod(SampleRequest request) throws TException {
		try{
			String name = request.getName() + " " + (request.getMiddleName() == null ? "" : request.getMiddleName()) + " "
					+ request.getLastname();
			return "Your name is: " + name + ". Your age is: " + request.getAge();
		}catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
			return "Exception";
		}
	}

}
