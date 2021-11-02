package must.harvest.harvest.services;


import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Member_WaitList;
import must.harvest.harvest.model.WaitList;
import must.harvest.harvest.repo.Member_WaitListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Member_WaitListService {
    private final Member_WaitListRepo member_waitListRepo;

    @Autowired
    public Member_WaitListService(Member_WaitListRepo member_waitListRepo) {
        this.member_waitListRepo = member_waitListRepo;
    }

    public Member_WaitList subscribeToWaitList(Member_WaitList member_waitList) {
        return member_waitListRepo.save(member_waitList);
    }

    public Member_WaitList updateSubscription(Member_WaitList member_waitList) {
        return member_waitListRepo.save(member_waitList);
    }

    public void deleteMemberFromWaitList(Member_WaitList member_waitList) {
        member_waitListRepo.deleteMember_WaitListByMembercinAndWaitListId(member_waitList.getMembercin(), member_waitList.getWaitListId());
    }

    public void deleteMemberFromAllWaitLists(Long cin) {
        member_waitListRepo.deleteMember_WaitListByMembercin(cin);
    }

    public List<WaitList> getMember_WaitLists(Long cin) {
        return member_waitListRepo.getMember_WaitLists(cin);
    }

    public List<Member> getMember_Per_WaitList(String type) {
        return member_waitListRepo.getMember_Per_WaitList(type);
    }
}
