package must.harvest.harvest.controllers;

import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.operation;
import must.harvest.harvest.services.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/getOperation/{oid}")
    public ResponseEntity<operation> getOperation(@PathVariable("oid") Long oid) {
        operation opr = operationService.getOperation(oid);
        return new ResponseEntity<>(opr, HttpStatus.OK);
    }

    @PostMapping("/getAllMemberOprations")
    public ResponseEntity<List<operation>> getAllMemberOps(@RequestBody Member member) {
        List<operation> operationList = operationService.getOperationsRelatedToMember(member);
        return new ResponseEntity<>(operationList, HttpStatus.OK);
    }

    @PostMapping("/addOperation")
    public ResponseEntity<operation> addOperation(@RequestBody operation opr) {
        operation opr1 = operationService.addOperation(opr);
        return new ResponseEntity<>(opr1, HttpStatus.CREATED);
    }

    @PostMapping("/updateOperation")
    public ResponseEntity<operation> updateOperation(@RequestBody operation opr) {
        operation opr1 = operationService.updateOperation(opr);
        return new ResponseEntity<>(opr1, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeOperation")
    public ResponseEntity<?> removeOperation(@RequestBody Long oid) {
        operationService.removeOperation(oid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllMemberOperations")
    public ResponseEntity<?> removeAllMemberOperations(@RequestBody Member member) {
        operationService.removeAllMemberOperations(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
