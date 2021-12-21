package org.your.reference.service.api;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.your.reference.service.RefServiceApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RefServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleApiITTest {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@SuppressWarnings("deprecation")
	@Test
	public void testTestApi() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/testapi"), HttpMethod.GET, entity,
				String.class);

		String expected = "Hi";
		String actual = response.getBody();

		Assert.isTrue(expected.equals(actual));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
