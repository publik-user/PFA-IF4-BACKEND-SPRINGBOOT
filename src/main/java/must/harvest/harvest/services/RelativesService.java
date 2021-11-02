package must.harvest.harvest.services;

import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Member_Relatives;
import must.harvest.harvest.repo.RelativesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RelativesService {
    private final RelativesRepo relativesRepo;

    @Autowired
    public RelativesService(RelativesRepo relativesRepo) {
        this.relativesRepo = relativesRepo;
    }

    public Member_Relatives addRelative(Member_Relatives member_relatives) {
        return relativesRepo.save(member_relatives);
    }

    public Member_Relatives updateRelative(Member_Relatives old_member_relatives, Member_Relatives new_member_relatives) {
        relativesRepo.deleteMember_RelativesByMcinAndRelative(old_member_relatives.getMcin(), old_member_relatives.getRelative());
        return relativesRepo.save(new_member_relatives);
    }

    public void deleteRelative(Long mcin, Long relativeId) {
        relativesRepo.deleteMember_RelativesByMcinAndRelative(mcin, relativeId);
    }

    public void deleteRelativeByMcin(Long cin) {
        relativesRepo.deleteMember_RelativesByMcin(cin);
    }

    public List<Member> getMyRelatives(Long cin) {
        return relativesRepo.getMember_Relatives(cin);
    }
}
