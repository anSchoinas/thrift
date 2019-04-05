package gr.aschoinas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Andreas Schoinas on 4/4/2019
 */
@Service
public class SampleRestService {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final String FILENAME = "C:\\new\\restbenchmark.txt";
	private BufferedWriter writer;

	@PostConstruct
	public void init() {
		try {
			FileWriter fw = new FileWriter(FILENAME, true);
			writer = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private RestTemplate sampleRestTemplate;

	public String callRestService(SampleRequest request) {
		String response = null;
		request.setLastName(randomAlphaNumeric(2500));
		request.setName(randomAlphaNumeric(2500));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SampleRequest> entity = new HttpEntity<>(request, headers);
		String uri = "http://localhost:8080/rest/test";
		try {
			long start = System.currentTimeMillis();
			ResponseEntity<String> restResponse = sampleRestTemplate.postForEntity(uri, entity, String.class);
			long end = System.currentTimeMillis();
			logTime(start, end);
			if (HttpStatus.OK.equals(restResponse.getStatusCode())) {
				response = restResponse.getBody();
			} else {
				response = "Error: " + restResponse.getStatusCode() + " - " + restResponse.getBody();
			}
		} catch (Exception e) {
			response = "Exception";
			e.printStackTrace();
		} finally {

		}

		return response;
	}


	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}


	private void logTime(long start, long end) {
		long timeDiff = end - start;
		try {
			writer.write(timeDiff + "\r\n");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
