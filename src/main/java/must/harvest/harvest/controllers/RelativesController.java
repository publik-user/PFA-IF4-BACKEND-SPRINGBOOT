package must.harvest.harvest.controllers;

import must.harvest.harvest.IdClasses.RelativeId;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Member_Relatives;
import must.harvest.harvest.services.RelativesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatives")
public class RelativesController {
    private final RelativesService relativesService;

    public RelativesController(RelativesService relativesService) {
        this.relativesService = relativesService;
    }

    @PostMapping("/add")
    public ResponseEntity<Member_Relatives> addRelative(@RequestBody Member_Relatives member_relatives) {
        Member_Relatives member_relatives1 = relativesService.addRelative(member_relatives);
        return new ResponseEntity<>(member_relatives1, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Member_Relatives> updateRelative(@RequestBody Member_Relatives[] member_relatives) {
        Member_Relatives member_relatives1 = relativesService.updateRelative(member_relatives[0], member_relatives[1]);
        return new ResponseEntity<>(member_relatives1, HttpStatus.CREATED);
    }

    @GetMapping("/getRelativesInfo/{mcin}")
    public ResponseEntity<List<Member>> getRelativesInfo(@PathVariable("mcin") Long mcin) {
        List<Member> relativesList = relativesService.getMyRelatives(mcin);
        return new ResponseEntity<>(relativesList, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRelative(@RequestBody RelativeId relativeId) {
        relativesService.deleteRelative(relativeId.getMcin(), relativeId.getRelative());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCin")
    public ResponseEntity<?> deleteRelativeByMcin(@RequestBody Long id) {
        relativesService.deleteRelativeByMcin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
