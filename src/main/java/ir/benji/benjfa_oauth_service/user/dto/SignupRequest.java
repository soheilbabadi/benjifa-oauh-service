package ir.benji.benjfa_oauth_service.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

public class SignupRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7777140461327006348L;
    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

}
