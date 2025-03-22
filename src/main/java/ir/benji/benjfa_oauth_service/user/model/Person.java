package ir.benji.benjfa_oauth_service.user.model;

import ir.benji.benjfa_oauth_service.user.enums.AccountRecoveryStatus;
import ir.benji.benjfa_oauth_service.user.enums.GenderStatus;
import ir.benji.benjfa_oauth_service.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "person", indexes = {
        @Index(name = "idx_username", columnList = "username"),
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_phone", columnList = "phone")
})
public class Person implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = -5889097686286326872L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String family;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length = 500, nullable = false)
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false, unique = true)
    private String phone;
    @Column(length = 10, nullable = false, unique = true)
    private String nationalCode;
    private String profileImage;
    @Column(length = 500, nullable = false)
    private String bio;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderStatus gender;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private UserStatus userStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private AccountRecoveryStatus accountRecoveryStatus;


    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate lastLoginDate;

    @Column(nullable = false)
    private LocalDate createdDate;


    private String instagram;
    private String twitter;
    private String linkedin;
    private String facebook;

    private long cityId;
    private String city;

    private long countryId;
    private String country;

    private double latitude;
    private double longitude;



    @Column(nullable = false)
    private boolean accountNonLocked;

    @Column(nullable = false)
    private boolean accountNonExpired;

    @Column(nullable = false)
    private boolean credentialsNonExpired;


    @Column(nullable = false)
    private boolean enabled;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<Roles> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.stream()
                .map(role -> new SimpleGrantedAuthority(String.format("ROLE_%s", role.getRole())))
                .forEach(authorities::add);
        return authorities;

    }


}
