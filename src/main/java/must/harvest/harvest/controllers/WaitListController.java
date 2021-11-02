package must.harvest.harvest.controllers;

import must.harvest.harvest.model.WaitList;
import must.harvest.harvest.services.WaitListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waitList")
public class WaitListController {
    private final WaitListService waitListService;

    public WaitListController(WaitListService waitListService) {
        this.waitListService = waitListService;
    }

    @GetMapping("/getAll")
    ResponseEntity<List<WaitList>> getAllWaitLists() {
        List<WaitList> waitLists = waitListService.getAllWaitLists();
        return new ResponseEntity<>(waitLists, HttpStatus.OK);
    }

    @GetMapping("/getByType/{type}")
    ResponseEntity<WaitList> getByType(@PathVariable("type") String type) {
        WaitList waitList = waitListService.getWaitListByType(type);
        return new ResponseEntity<>(waitList, HttpStatus.OK);
    }

    @PostMapping("/addList")
    ResponseEntity<WaitList> addList(@RequestBody WaitList waitList) {
        if (waitListService.getWaitListByType(waitList.getType()) != null)
            return new ResponseEntity<>(waitList, HttpStatus.FOUND);
        WaitList waitList1 = waitListService.addNewWaitList(waitList);
        return new ResponseEntity<>(waitList1, HttpStatus.CREATED);
    }

    @PostMapping("/updateList")
    ResponseEntity<WaitList> updateList(@RequestBody WaitList waitList) {
        if (waitList.getType() == null || waitList.getWid() == null)
            return new ResponseEntity<>(waitList, HttpStatus.PARTIAL_CONTENT);
        WaitList waitList1 = waitListService.updateWaitList(waitList);
        return new ResponseEntity<>(waitList1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteList/{id}")
    ResponseEntity<?> deleteList(@PathVariable("id") Long id) {
        waitListService.deleteWaitList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
