package must.harvest.harvest.controllers;

import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Member_WaitList;
import must.harvest.harvest.model.WaitList;
import must.harvest.harvest.services.Member_WaitListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Member_WaitList")
public class Member_WaitListController {
    private final Member_WaitListService member_waitListService;

    public Member_WaitListController(Member_WaitListService member_waitListService) {
        this.member_waitListService = member_waitListService;
    }

    @PostMapping("/subscribeToList")
    public ResponseEntity<Member_WaitList> subscribeToWaitList(@RequestBody Member_WaitList member_waitList) {
        Member_WaitList member_waitList1 = member_waitListService.subscribeToWaitList(member_waitList);
        return new ResponseEntity<>(member_waitList1, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Member_WaitList> updateSubscription(@RequestBody Member_WaitList member_waitList) {
        Member_WaitList member_waitList1 = member_waitListService.updateSubscription(member_waitList);
        return new ResponseEntity<>(member_waitList1, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeFromWaitList")
    public ResponseEntity<?> deleteMemberFromWaitList(@RequestBody Member_WaitList member_waitList) {
        member_waitListService.deleteMemberFromWaitList(member_waitList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeFromAllWaitLists/{cin}")
    public ResponseEntity<?> deleteMemberFromAllWaitLists(@PathVariable("cin") Long cin) {
        member_waitListService.deleteMemberFromAllWaitLists(cin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getMemberWaitLists/{cin}")
    public ResponseEntity<List<WaitList>> getMember_WaitLists(@PathVariable("cin") Long cin) {
        List<WaitList> memberWaitLists = member_waitListService.getMember_WaitLists(cin);
        return new ResponseEntity<>(memberWaitLists, HttpStatus.OK);
    }

    @GetMapping("/GetMembersInList/{type}")
    public ResponseEntity<List<Member>> getMember_Per_WaitList(@PathVariable("type") String type) {
        List<Member> membersInList = member_waitListService.getMember_Per_WaitList(type);
        return new ResponseEntity<>(membersInList, HttpStatus.OK);
    }


}
