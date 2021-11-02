package must.harvest.harvest.repo;

import must.harvest.harvest.IdClasses.WaitListId;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Member_WaitList;
import must.harvest.harvest.model.WaitList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Member_WaitListRepo extends JpaRepository<Member_WaitList, WaitListId> {
    void deleteMember_WaitListByMembercinAndWaitListId(Long member_cin, Long waitListId);

    void deleteMember_WaitListByMembercin(Long member_cin);

    @Query("select w from WaitList w, Member_WaitList mw where mw.membercin=?1 and mw.waitListId=w.wid")
    List<WaitList> getMember_WaitLists(Long cin);

    @Query("select m from Member m, Member_WaitList mw, WaitList w where w.type=?1 and w.wid=mw.waitListId and mw.membercin=m.CIN")
    List<Member> getMember_Per_WaitList(String type);
}
