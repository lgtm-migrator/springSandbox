package nc.dva.examples.player;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nc.dva.examples.hystrix.PaysEtTerritoiresEtrangers;

@RestController
@CrossOrigin(origins = "*")
public class PlayerController {

	private Environment environment;
	private PlayerRepository lRepository;

	private final String gatewayBaseURI;

	private final RestTemplate restTemplate = new RestTemplate();

	public PlayerController(Environment env, PlayerRepository repo) {
		this.environment = env;
		this.lRepository = repo;
		this.gatewayBaseURI = Arrays.asList(environment.getActiveProfiles()).contains("docker")
				? "http://spring-cloud-gateway:10200"
				: "http://localhost:10200";
	}

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

		String finalURI = gatewayBaseURI + "/geolocation/api/v1/countries";

		System.out.println(finalURI);

		PaysEtTerritoiresEtrangers[] result = restTemplate.getForObject(finalURI, PaysEtTerritoiresEtrangers[].class);

		System.out.println(result);

		return new HttpEntity<Object>(result);

	}

}
