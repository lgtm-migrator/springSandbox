package nc.dva.examples.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, PlayerId> {

	@Query(name = "ListCountriesDistinct", value = "SELECT DISTINCT p.country FROM Player p")
	List<String> findCountries();

}
