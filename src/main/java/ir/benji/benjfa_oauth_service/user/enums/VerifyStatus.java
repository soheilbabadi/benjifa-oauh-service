package ir.benji.benjfa_oauth_service.user.enums;

import lombok.Getter;

@Getter
public enum VerifyStatus {
    USER("USER"),
    SITTER("SITTER"),
    VET("VET"),
    SUSPENDED("SUSPENDED");


    private final String value;

    VerifyStatus(String value) {
        this.value = value;
    }
}