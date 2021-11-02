package must.harvest.harvest.repo;

import must.harvest.harvest.model.Hashes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HashRepo extends JpaRepository<Hashes, String> {
    void deleteHashByStuff(String Code);

    @Query("select h from Hashes h where h.stuff = ?1")
    Optional<Hashes> findHashesByStuff(String Code);
}
