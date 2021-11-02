package must.harvest.harvest.repo;

import must.harvest.harvest.IdClasses.RelativeId;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Member_Relatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativesRepo extends JpaRepository<Member_Relatives, RelativeId> {
    void deleteMember_RelativesByMcinAndRelative(Long mcin, Long relative);

    void deleteMember_RelativesByMcin(Long id);

    @Query("select m from Member m, Member_Relatives r where r.mcin=?1 and r.relative=m.CIN")
    List<Member> getMember_Relatives(Long cin);

}
