package must.harvest.harvest.services;

import must.harvest.harvest.exception.HashNotFoundException;
import must.harvest.harvest.model.Hashes;
import must.harvest.harvest.repo.HashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HashService {
    private final HashRepo hashRepo;

    @Autowired
    public HashService(HashRepo hashRepo) {
        this.hashRepo = hashRepo;
    }

    public Hashes addHash(Hashes hash) {
        return hashRepo.save(hash);
    }

    public Hashes updateHash(Hashes hash) {
        return hashRepo.save(hash);
    }

    public Hashes findHashById(String HashCode) throws HashNotFoundException {
        return hashRepo.findHashesByStuff(HashCode).orElseThrow(() -> new HashNotFoundException("your credentials might be wrong !"));
    }

    public void deleteHash(String HashCode) {
        hashRepo.deleteHashByStuff(HashCode);
    }




}
