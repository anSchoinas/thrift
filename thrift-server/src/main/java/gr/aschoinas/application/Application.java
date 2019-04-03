package gr.aschoinas.application;

import gr.aschoinas.generated.SampleService;
import gr.aschoinas.thrift.SampleServiceControllerHandler;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Application {

	@Autowired
	SampleServiceControllerHandler handler;

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public TProtocolFactory tProtocolFactory() {
		//We will use binary protocol, but it's possible to use JSON and others
		return new TBinaryProtocol.Factory();
	}

	@Bean
	public SampleServiceControllerHandler handler() {
		return new SampleServiceControllerHandler();
	}

	@Bean
	public ServletRegistrationBean thrift(TProtocolFactory tProtocolFactory) {
		TServlet servlet = new TServlet(new SampleService.Processor<SampleServiceControllerHandler>(handler), tProtocolFactory);
		//Map your handler to the desired endpoint:
		//This will map the request handler to: "http://localhost:8000/thrift"
		return new ServletRegistrationBean(servlet, "/thrift");
	}
}
