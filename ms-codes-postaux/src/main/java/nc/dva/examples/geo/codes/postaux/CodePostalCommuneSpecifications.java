package nc.dva.examples.geo.codes.postaux;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CodePostalCommuneSpecifications {

	public static Specification<CodePostalCommune> codePostalStartWith(String content) {
		return startWith(CodePostalCommune_.codePostal, content);
	}

	public static Specification<CodePostalCommune> nomCommuneStartWith(String content) {
		return startWith(CodePostalCommune_.nomCommune, content);
	}

	public static Specification<CodePostalCommune> codePostalStartWithAndNomCommuneStartWith(String codePostalContent,
			String nomCommuneContent) {
		return (root, query, cb) -> cb.and(
				cb.like(cb.lower(root.get(CodePostalCommune_.codePostal)), codePostalContent.toLowerCase() + "%"),
				cb.like(cb.lower(root.get(CodePostalCommune_.nomCommune)), nomCommuneContent.toLowerCase() + "%"));
	}

	private static Specification<CodePostalCommune> startWith(SingularAttribute<CodePostalCommune, String> propertyname,
			String content) {
		return !StringUtils.hasText(content) ? null
				: (root, query, cb) -> cb.like(cb.lower(root.get(propertyname)), content.toLowerCase() + "%");
	}

}
