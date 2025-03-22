package ir.benji.benjfa_oauth_service.user.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JwtAuthenticationResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6822040918713335739L;
    private String token;
    private String refreshToken;
}
