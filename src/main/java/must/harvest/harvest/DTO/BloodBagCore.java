package must.harvest.harvest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import must.harvest.harvest.model.BloodBag;
import must.harvest.harvest.model.Member;
import must.harvest.harvest.model.Storage;
import must.harvest.harvest.model.operation;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodBagCore implements Serializable {
    private BloodBag bloodBag;
    private operation OprBlood;
    private Member memberBloodBag;
    private Storage bloodStorage;
}
