package must.harvest.harvest.repo;

import must.harvest.harvest.model.BloodBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BloodBagRepo extends JpaRepository<BloodBag, Long> {
    void deleteBloodBagByBID(Long id);

    List<BloodBag> findBloodBagsByBloodType(String type);
}
