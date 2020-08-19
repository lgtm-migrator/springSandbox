package nc.dva.examples.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PlayerController {

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

}
