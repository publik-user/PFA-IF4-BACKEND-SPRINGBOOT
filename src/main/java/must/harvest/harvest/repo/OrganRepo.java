package must.harvest.harvest.repo;

import must.harvest.harvest.model.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganRepo extends JpaRepository<Organ, Long> {
}
