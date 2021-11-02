package must.harvest.harvest.IdClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelativeId implements Serializable {
    private Long mcin;
    private Long relative;
}
