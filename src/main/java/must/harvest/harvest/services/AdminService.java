package must.harvest.harvest.services;

import must.harvest.harvest.model.Admin;
import must.harvest.harvest.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin getAdmin(Long cin) {
        return adminRepo.getOne(cin);
    }

    public void deleteAdmin(Long cin) {
        adminRepo.deleteById(cin);
    }
}
