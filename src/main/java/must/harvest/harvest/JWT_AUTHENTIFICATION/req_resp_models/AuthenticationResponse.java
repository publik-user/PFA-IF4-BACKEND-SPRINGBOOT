package must.harvest.harvest.JWT_AUTHENTIFICATION.req_resp_models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
