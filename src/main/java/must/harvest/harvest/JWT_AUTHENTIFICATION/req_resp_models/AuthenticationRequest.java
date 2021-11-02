package must.harvest.harvest.JWT_AUTHENTIFICATION.req_resp_models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {
    private Long cin;
    private String password;
}
