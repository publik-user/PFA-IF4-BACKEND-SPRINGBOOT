package must.harvest.harvest.IdClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaitListId implements Serializable {
    private Long membercin;
    private Long waitListId;
}
