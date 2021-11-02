package must.harvest.harvest.controllers;

import must.harvest.harvest.DTO.BloodBagCore;
import must.harvest.harvest.model.BloodBag;
import must.harvest.harvest.services.BloodBagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodbag")
public class BloodBagController {
    private final BloodBagService bloodBagService;

    public BloodBagController(BloodBagService bloodBagService) {
        this.bloodBagService = bloodBagService;
    }

    @PostMapping("/add1")
    public ResponseEntity<BloodBag> addBloodBag(@RequestBody BloodBagCore bloodBagCore) {
        BloodBag bloodBag = bloodBagService.addBloodBag(bloodBagCore.getBloodBag(), bloodBagCore.getMemberBloodBag(), bloodBagCore.getBloodStorage());
        return new ResponseEntity<>(bloodBag, HttpStatus.CREATED);
    }

    @PostMapping("/add2")
    public ResponseEntity<BloodBag> addBloodBagOp(@RequestBody BloodBagCore bloodBagCore) {
        BloodBag bloodBag = bloodBagService.addBloodBag(bloodBagCore.getBloodBag(), bloodBagCore.getOprBlood(), bloodBagCore.getMemberBloodBag(), bloodBagCore.getBloodStorage());
        return new ResponseEntity<>(bloodBag, HttpStatus.CREATED);
    }

    @PostMapping("/update1")
    public ResponseEntity<BloodBag> updateBloodBag(@RequestBody BloodBag bloodBag) {
        BloodBag bloodBag1 = bloodBagService.updateBloodBag(bloodBag);
        return new ResponseEntity<>(bloodBag1, HttpStatus.CREATED);
    }

    @PostMapping("/update2")
    public ResponseEntity<BloodBag> updateBloodBag(@RequestBody BloodBagCore bloodBagCore) {
        BloodBag bloodBag1 = bloodBagService.updateBloodBag(bloodBagCore.getBloodBag(), bloodBagCore.getOprBlood(), bloodBagCore.getBloodStorage());
        return new ResponseEntity<>(bloodBag1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBloodBag(@PathVariable("id") Long id) {
        bloodBagService.deleteBloodBag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/purge")
    public ResponseEntity<?> purge() {
        bloodBagService.purge();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findBloodType/{btype}")
    public ResponseEntity<List<BloodBag>> findByBloodType(@PathVariable("btype") String bloodType) {
        List<BloodBag> bloodBags = bloodBagService.findByBloodType(bloodType);
        return new ResponseEntity<>(bloodBags, HttpStatus.OK);
    }

    @GetMapping("/findAllBloodBags")
    public ResponseEntity<List<BloodBag>> findByBloodType() {
        List<BloodBag> bloodBags = bloodBagService.findAllBloodBags();
        return new ResponseEntity<>(bloodBags, HttpStatus.OK);
    }


}
