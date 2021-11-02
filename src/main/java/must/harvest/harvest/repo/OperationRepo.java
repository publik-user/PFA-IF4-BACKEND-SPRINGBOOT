package must.harvest.harvest.repo;

import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<operation, Long> {
    void deleteByOID(Long oid);

    void deleteByMemberOprs(Member member);

    List<operation> findByMemberOprs(Member member);
}
