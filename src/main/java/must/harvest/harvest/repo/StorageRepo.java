package must.harvest.harvest.repo;

import must.harvest.harvest.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Long> {

    void deleteStorageBySID(Long id);

    List<Storage> findStorageByNameContains(String name);

    List<Storage> findStorageByLocationContains(String location);
}
