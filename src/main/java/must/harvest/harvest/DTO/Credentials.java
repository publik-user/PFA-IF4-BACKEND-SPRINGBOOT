package must.harvest.harvest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials implements Serializable {
    private Long CIN;
    private String password;
}
