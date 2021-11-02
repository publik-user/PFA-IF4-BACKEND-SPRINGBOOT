package must.harvest.harvest.controllers;

import must.harvest.harvest.exception.NotFoundException;
import must.harvest.harvest.model.Organ;
import must.harvest.harvest.services.OrganService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organ")
public class OrganController {
    private final OrganService organService;

    public OrganController(OrganService organService) {
        this.organService = organService;
    }

    @GetMapping("/getOrgan/{id}")
    public ResponseEntity<Organ> getOrgan(@PathVariable("id") Long id) {
        Organ organ = null;
        try {
            organ = organService.getOrgan(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(organ, HttpStatus.OK);
    }

    @PostMapping("/addOrgan")
    public ResponseEntity<Organ> addOrgan(@RequestBody Organ organ) {
        Organ organ1 = organService.addOrgan(organ);
        return new ResponseEntity<>(organ1, HttpStatus.CREATED);
    }

    @PostMapping("/updateOrgan")
    public ResponseEntity<Organ> updateOrgan(@RequestBody Organ organ) {
        Organ organ1 = organService.updateOrgan(organ);
        return new ResponseEntity<>(organ1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOrgan/{id}")
    public ResponseEntity<?> deleteOrgan(@PathVariable("id") Long id) {
        organService.deleteOrgan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
