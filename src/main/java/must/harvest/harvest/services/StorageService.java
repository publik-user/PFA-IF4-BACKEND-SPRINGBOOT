package must.harvest.harvest.services;

import must.harvest.harvest.model.Storage;
import must.harvest.harvest.repo.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StorageService {

    private final StorageRepo storageRepo;

    @Autowired
    public StorageService(StorageRepo storageRepo) {
        this.storageRepo = storageRepo;
    }

    public Storage addStorage(Storage storage) {
        return storageRepo.save(storage);
    }

    public Storage updateStorage(Storage storage) {
        return storageRepo.save(storage);
    }

    public void deleteStorage(Long id) {
        storageRepo.deleteStorageBySID(id);
    }

    public void purge() {
        storageRepo.deleteAll();
    }

    public List<Storage> getAll() {
        return storageRepo.findAll();
    }

    public List<Storage> findByName(String name) {
        return storageRepo.findStorageByNameContains(name);
    }

    public List<Storage> findByLocation(String location) {
        return storageRepo.findStorageByLocationContains(location);
    }


}
