package must.harvest.harvest.services;

import must.harvest.harvest.model.WaitList;
import must.harvest.harvest.repo.WaitListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WaitListService {
    private final WaitListRepo waitListRepo;

    @Autowired
    public WaitListService(WaitListRepo waitListRepo) {
        this.waitListRepo = waitListRepo;
    }

    public WaitList addNewWaitList(WaitList waitList) {
        return waitListRepo.save(waitList);
    }

    public WaitList updateWaitList(WaitList waitList) {
        return waitListRepo.save(waitList);
    }

    public void deleteWaitList(Long wid) {
        waitListRepo.deleteWaitListByWid(wid);
    }

    public List<WaitList> getAllWaitLists() {
        return waitListRepo.findAll();
    }

    public WaitList getWaitListByType(String type) {
        return waitListRepo.findWaitListByType(type);
    }


}
