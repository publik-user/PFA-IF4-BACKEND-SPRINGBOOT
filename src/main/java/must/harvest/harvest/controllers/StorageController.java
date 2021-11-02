package must.harvest.harvest.controllers;

import must.harvest.harvest.model.Storage;
import must.harvest.harvest.services.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Storage>> getAllStorage() {
        List<Storage> storages = storageService.getAll();
        return new ResponseEntity<>(storages, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Storage>> getByName(@PathVariable("name") String name) {
        List<Storage> storages = storageService.findByName(name);
        return new ResponseEntity<>(storages, HttpStatus.OK);
    }

    @GetMapping("/find/{location}")
    public ResponseEntity<List<Storage>> getByLocation(@PathVariable("location") String location) {
        List<Storage> storages = storageService.findByLocation(location);
        return new ResponseEntity<>(storages, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Storage> addStorage(@RequestBody Storage storage) {
        Storage storage1 = storageService.addStorage(storage);
        return new ResponseEntity<>(storage1, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Storage> updateStorage(@RequestBody Storage storage) {
        Storage storage1 = storageService.updateStorage(storage);
        return new ResponseEntity<>(storage1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStorage(@PathVariable("id") Long id) {
        storageService.deleteStorage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/purge")
    public ResponseEntity<?> purge() {
        storageService.purge();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
