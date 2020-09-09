package nc.dva.examples.countries;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PaysEtTerritoiresEtrangersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaysEtTerritoiresEtrangersController.class);

	@Autowired
	private PaysEtTerritoiresEtrangersRepository lRepository;

	@Cacheable("countries")
	@RequestMapping(path = "/api/v1/countries")
	public HttpEntity<?> getCountries() {

		LOGGER.info("Start calling /api/v1/countries endpoint");

		List<PaysEtTerritoiresEtrangers> result = null;

		/*
		 * Default pessimistic response.
		 */
		HttpEntity<?> response = new HttpEntity<>(HttpStatus.NOT_FOUND);

		result = lRepository.findAll();

		if (result != null && !result.isEmpty()) {
			response = new HttpEntity<List<PaysEtTerritoiresEtrangers>>(result);

			LOGGER.debug(result.toString());

		}

		LOGGER.info("End calling /api/v1/countries endpoint");

		return response;

	}
}
