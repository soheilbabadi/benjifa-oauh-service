package ir.benji.benjfa_oauth_service.user.enums;

import lombok.Getter;

@Getter
public enum GenderStatus {

    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");
    private final String value;

    GenderStatus(String value) {
        this.value = value;
    }
}
