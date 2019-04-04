package gr.aschoinas.rest;

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
@RequestMapping("/rest")
public class SampleRestController {

	@PostMapping(value = "/test")
	public String test (@RequestBody final SampleRequest input) {
		return "Your name is: " + input.getName() + " " + input.getLastName()
				+ ". And your age is: " + input.getAge();
	}
}
