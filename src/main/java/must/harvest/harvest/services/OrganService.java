package must.harvest.harvest.services;

import must.harvest.harvest.exception.NotFoundException;
import must.harvest.harvest.model.Organ;
import must.harvest.harvest.repo.OrganRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrganService {
    private final OrganRepo organRepo;

    @Autowired
    public OrganService(OrganRepo organRepo) {
        this.organRepo = organRepo;
    }

    public Organ addOrgan(Organ organ) {
        return organRepo.save(organ);
    }

    public Organ updateOrgan(Organ organ) {
        return organRepo.save(organ);
    }

    public Organ getOrgan(Long id) throws NotFoundException {
        return organRepo.findById(id).orElseThrow(() -> new NotFoundException("Organ Was Not Found !"));
    }

    public void deleteOrgan(Long id) {
        organRepo.deleteById(id);
    }
}
