package must.harvest.harvest.services;

import must.harvest.harvest.model.BloodBag;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Storage;
import must.harvest.harvest.model.operation;
import must.harvest.harvest.repo.BloodBagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BloodBagService {

    private final BloodBagRepo bloodBagRepo;

    @Autowired
    public BloodBagService(BloodBagRepo bloodBagRepo) {
        this.bloodBagRepo = bloodBagRepo;
    }

    public BloodBag addBloodBag(BloodBag bloodBag, Member memberBloodBag, Storage bloodStorage) {
        bloodBag.setMemberBloodBag(memberBloodBag);
        bloodBag.setBloodStorage(bloodStorage);
        return bloodBagRepo.save(bloodBag);
    }

    public BloodBag addBloodBag(BloodBag bloodBag, operation OprBlood, Member memberBloodBag, Storage bloodStorage) {
        bloodBag.setMemberBloodBag(memberBloodBag);
        bloodBag.setBloodStorage(bloodStorage);
        bloodBag.setOprBlood(OprBlood);
        return bloodBagRepo.save(bloodBag);
    }

    public List<BloodBag> findAllBloodBags() {
        return bloodBagRepo.findAll();
    }

    public List<BloodBag> findByBloodType(String bloodType) {
        return bloodBagRepo.findBloodBagsByBloodType(bloodType);
    }

    public BloodBag updateBloodBag(BloodBag bloodBag, operation OprBlood, Storage bloodStorage) {
        bloodBag.setBloodStorage(bloodStorage);
        bloodBag.setOprBlood(OprBlood);
        return bloodBagRepo.save(bloodBag);
    }

    public BloodBag updateBloodBag(BloodBag bloodBag) {
        return bloodBagRepo.save(bloodBag);
    }

    public void deleteBloodBag(Long id) {
        bloodBagRepo.deleteBloodBagByBID(id);
    }

    public void purge() {
        bloodBagRepo.deleteAll();
    }


}
