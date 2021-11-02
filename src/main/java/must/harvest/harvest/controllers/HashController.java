package must.harvest.harvest.controllers;

import must.harvest.harvest.DTO.Credentials;
import must.harvest.harvest.exception.HashNotFoundException;
import must.harvest.harvest.model.Hashes;
import must.harvest.harvest.services.HashService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/Hash")
public class HashController {
    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @PostMapping("/find")
    public ResponseEntity<Hashes> getHashByid(@RequestBody Credentials credentials) throws HashNotFoundException {
        Hashes hash = hashService.findHashById(getHash(credentials.getCIN(), credentials.getPassword()));
        return new ResponseEntity<>(hash, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hashes> addHash(@RequestBody Credentials credentials) {
        Hashes hash = hashService.addHash(new Hashes(getHash(credentials.getCIN(), credentials.getPassword())));
        return new ResponseEntity<>(hash, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Hashes> updateHash(@RequestBody Credentials[] credentials) {
        hashService.deleteHash(getHash(credentials[0].getCIN(), credentials[0].getPassword()));
        Hashes hash = hashService.updateHash(new Hashes(getHash(credentials[1].getCIN(), credentials[1].getPassword())));
        return new ResponseEntity<>(hash, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteHash(@RequestBody Credentials credentials) {
        hashService.deleteHash(getHash(credentials.getCIN(), credentials.getPassword()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String getHash(Long CIN, String password) {
        String text = "azdbnzaoifdobfcouabfuiaebfiaevbfuizagvbfua" + CIN + "$$$azd$az;:d,azdiazhndpianzfazefuobaf" + password + "é~dzafd$$aadaazdonifosbqbdueauuuebe<5546464";
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedHash = digest.digest(text.getBytes(StandardCharsets.ISO_8859_1));
        return new String(encodedHash, StandardCharsets.ISO_8859_1);
    }
}
