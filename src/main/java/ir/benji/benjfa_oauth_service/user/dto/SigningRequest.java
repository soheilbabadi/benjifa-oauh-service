package ir.benji.benjfa_oauth_service.user.dto;

import jakarta.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

public class SigningRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -3416303990497776634L;
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
   private String password;
}
