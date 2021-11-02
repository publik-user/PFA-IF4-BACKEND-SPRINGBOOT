package must.harvest.harvest.services;

import must.harvest.harvest.exception.MemberAllReadyPresent;
import must.harvest.harvest.exception.MemberNotFoundException;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {
    private final MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Member addMember(Member member) throws MemberAllReadyPresent {
        if (memberRepo.findMemberByCIN(member.getCIN()).isPresent())
            throw new MemberAllReadyPresent("you already have an account");
        return memberRepo.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepo.findAll();
    }

    public Member updateMember(Member member) {
        return memberRepo.save(member);
    }

    public Member findMemberById(Long cin) throws MemberNotFoundException {
        return memberRepo.findMemberByCIN(cin).orElseThrow(() -> new MemberNotFoundException("Member by id " + cin + " was not found"));
    }

    public void deleteMember(Long cin) {
        memberRepo.deleteMemberByCIN(cin);
    }

}
