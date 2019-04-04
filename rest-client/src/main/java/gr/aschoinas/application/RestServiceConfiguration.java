package gr.aschoinas.application;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Andreas Schoinas on 4/4/2019
 */
@Configuration
public class RestServiceConfiguration {


	@Bean
	public PoolingHttpClientConnectionManager restPoolingHttpClientConnectionManager() {
		PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
		pool.setMaxTotal(1000);
		pool.setDefaultMaxPerRoute(10);
		pool.setValidateAfterInactivity(10);
		return pool;
	}

	@Bean
	public RequestConfig sampleRestRequestConfig() {
		return RequestConfig.custom().setConnectionRequestTimeout(100).setConnectTimeout(100)
				.setSocketTimeout(500).build();
	}


	@Bean
	public CloseableHttpClient sampleRestHttpClient(final PoolingHttpClientConnectionManager restPoolingHttpClientConnectionManager,
													final RequestConfig sampleRestRequestConfig) {
		return HttpClientBuilder.create().setConnectionManager(restPoolingHttpClientConnectionManager)
				.setDefaultRequestConfig(sampleRestRequestConfig).build();
	}

	@Bean
	public RestTemplate sampleRestTemplate(final RestTemplateBuilder builder, final CloseableHttpClient sampleRestHttpClient) {
		HttpComponentsClientHttpRequestFactory restHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		restHttpRequestFactory.setHttpClient(sampleRestHttpClient);
		return builder.build();
	}
}
