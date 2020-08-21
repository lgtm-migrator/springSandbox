package nc.dva.examples.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nc.dva.examples.hystrix.Country;

@RestController
@CrossOrigin(origins = "*")
public class PlayerController {

	private final String gatewayURI = "http://spring-cloud-gateway:10200";

	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private PlayerRepository lRepository;

	@RequestMapping(path = "/api/v1/players")
	public HttpEntity<?> getAllPlayer() {

		List<Player> result = null;

		/*
		 * Default pessimistic response
		 */
		HttpEntity<?> response = new HttpEntity<>(HttpStatus.NOT_FOUND);

		result = lRepository.findAll();

		if (result != null && !result.isEmpty()) {
			response = new HttpEntity<List<Player>>(result);
		}

		return response;
	}

	@GetMapping(path = "/api/v1/countries")
	public HttpEntity<?> getAllCountries() {

		String finalURI = gatewayURI + "/geolocation/api/v1/countries";

		System.out.println(finalURI);

		Country[] result = restTemplate.getForObject(finalURI, Country[].class);

		System.out.println(result);

		return new HttpEntity<Object>(result);

	}

}
