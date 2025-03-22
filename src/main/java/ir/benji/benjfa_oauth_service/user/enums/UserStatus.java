package ir.benji.benjfa_oauth_service.user.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    SUSPENDED("SUSPENDED"),
    DELETED("DELETED");


    private final String value;

    UserStatus(String value) {
        this.value = value;
    }
}