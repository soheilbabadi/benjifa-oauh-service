package ir.benji.benjfa_oauth_service.user.enums;

import lombok.Getter;

@Getter
public enum AccountRecoveryStatus {

    EMAIL("EMAIL"),
    SMS("SMS"),
    APP("APP");

    private final String value;

    AccountRecoveryStatus(String value) {
        this.value = value;
    }
}
