package nc.dva.examples.geo.codes.postaux;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CodePostalCommuneRepository
		extends JpaRepository<CodePostalCommune, String>, JpaSpecificationExecutor<CodePostalCommune> {

}
