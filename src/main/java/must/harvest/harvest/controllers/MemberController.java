package must.harvest.harvest.controllers;

import must.harvest.harvest.exception.MemberAllReadyPresent;
import must.harvest.harvest.exception.MemberNotFoundException;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Member> getMemberByid(@PathVariable("id") Long id) throws MemberNotFoundException {
        Member member = memberService.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member) throws MemberAllReadyPresent {
        Member newMember = memberService.addMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        Member UpdatedMember = memberService.updateMember(member);
        return new ResponseEntity<>(UpdatedMember, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}














