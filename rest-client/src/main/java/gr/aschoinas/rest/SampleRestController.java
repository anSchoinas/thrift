package gr.aschoinas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Andreas Schoinas on 4/4/2019
 */
@RestController
@RequestMapping("/rest-client")
public class SampleRestController {

	@Autowired
	private SampleRestService restService;

	@PostMapping(value = "/test")
	public String test (@RequestBody final SampleRequest input) {
		return restService.callRestService(input);
	}
}
