package nc.dva.examples.geo.codes.postaux;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodePostalCommuneController {

	@Autowired
	private CodePostalCommuneRepository repository;

	@GetMapping("/api/v1/communes")
	public ResponseEntity<?> getCommunes(
			@RequestParam(name = "code-postal", required = false) final Optional<String> pCodePostal,
			@RequestParam(name = "nom-commune", required = false) final Optional<String> pNomCommune) {

		/*
		 * default pessimistic response
		 */
		ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		if (pCodePostal.isPresent()) {
			if (pNomCommune.isPresent()) {

				response = new ResponseEntity<>(
						repository.findAll(CodePostalCommuneSpecifications
								.codePostalStartWithAndNomCommuneStartWith(pCodePostal.get(), pNomCommune.get())),
						HttpStatus.OK);

			} else {
				response = new ResponseEntity<>(
						repository.findAll(CodePostalCommuneSpecifications.codePostalStartWith(pCodePostal.get())),
						HttpStatus.OK);
			}
		} else {
			if (pNomCommune.isPresent()) {
				response = new ResponseEntity<>(
						repository.findAll(CodePostalCommuneSpecifications.nomCommuneStartWith(pNomCommune.get())),
						HttpStatus.OK);
			}
		}

		return response;

	}
}
