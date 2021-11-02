package must.harvest.harvest.services;

import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.operation;
import must.harvest.harvest.repo.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperationService {
    private final OperationRepo operationRepo;

    @Autowired
    public OperationService(OperationRepo operationRepo) {
        this.operationRepo = operationRepo;
    }

    public operation addOperation(operation opr) {
        return operationRepo.save(opr);
    }

    public operation updateOperation(operation opr) {
        return operationRepo.save(opr);
    }

    public void removeOperation(Long oid) {
        operationRepo.deleteByOID(oid);
    }

    public operation getOperation(Long oid) {
        return operationRepo.getOne(oid);
    }

    public List<operation> getOperationsRelatedToMember(Member member) {
        return operationRepo.findByMemberOprs(member);
    }

    public void removeAllMemberOperations(Member member) {
        operationRepo.deleteByMemberOprs(member);
    }


}
