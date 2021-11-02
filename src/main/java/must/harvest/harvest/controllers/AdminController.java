package must.harvest.harvest.controllers;

import must.harvest.harvest.model.Admin;
import must.harvest.harvest.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAdmin/{cin}")
    public ResponseEntity<Admin> getAdmin(@PathVariable("cin") Long cin) {
        Admin admin = adminService.getAdmin(cin);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin admin1 = adminService.addAdmin(admin);
        return new ResponseEntity<>(admin1, HttpStatus.CREATED);
    }

    @PostMapping("/updateAdmin")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        Admin admin1 = adminService.updateAdmin(admin);
        return new ResponseEntity<>(admin1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAdmin/{cin}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("cin") Long cin) {
        adminService.deleteAdmin(cin);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
