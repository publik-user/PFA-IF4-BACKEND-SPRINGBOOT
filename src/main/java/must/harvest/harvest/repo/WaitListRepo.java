package must.harvest.harvest.repo;

import must.harvest.harvest.model.WaitList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WaitListRepo extends JpaRepository<WaitList, Long> {
    void deleteWaitListByWid(Long wid);

    WaitList findWaitListByType(String type);
}
