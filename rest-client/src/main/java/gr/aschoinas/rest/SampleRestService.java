package gr.aschoinas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Andreas Schoinas on 4/4/2019
 */
@Service
public class SampleRestService {

	@Autowired
	private RestTemplate sampleRestTemplate;

	public String callRestService(SampleRequest request){
		String response = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SampleRequest> entity = new HttpEntity<>(request, headers);
		String uri = "http://localhost:8080/rest/test";
		try {
			ResponseEntity<String> restResponse = sampleRestTemplate.postForEntity(uri, entity, String.class);
			if (HttpStatus.OK.equals(restResponse.getStatusCode())) {
				response = restResponse.getBody();
			} else {
				response = "Error: " + restResponse.getStatusCode() + " - " + restResponse.getBody();
			}
		} catch (Exception e) {
			response = "Exception";
			e.printStackTrace();
		}

		return response;
	}
}
