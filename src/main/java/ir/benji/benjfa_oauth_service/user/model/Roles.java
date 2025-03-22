package ir.benji.benjfa_oauth_service.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "role")
public class Roles {

    @Id
    private String id;
    private String role;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST},targetEntity = Person.class)
    @JoinTable(name = "person_roles",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Person> persons;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST},targetEntity = Grant.class)
    @JoinTable(name = "role_grant",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "grant_id"))
    private List<Grant> grants;

}
