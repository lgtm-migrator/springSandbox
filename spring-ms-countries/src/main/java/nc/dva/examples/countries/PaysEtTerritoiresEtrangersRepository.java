package nc.dva.examples.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysEtTerritoiresEtrangersRepository extends JpaRepository<PaysEtTerritoiresEtrangers, String> {

}
