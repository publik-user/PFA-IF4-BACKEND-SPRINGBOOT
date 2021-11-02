package must.harvest.harvest.repo;

import must.harvest.harvest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
    void deleteMemberByCIN(Long id);

    Optional<Member> findMemberByCIN(Long id);

    @Query("select m from Member m where m.CIN = ?1")
    Member findMemberByCIN_2(Long cin);


}
