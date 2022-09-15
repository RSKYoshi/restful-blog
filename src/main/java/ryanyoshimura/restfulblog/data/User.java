package ryanyoshimura.restfulblog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Collection;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length=100)
    private String userName;

    @Email
    @NotEmpty
    @Column(nullable = false, length = 100)
    private String email;

    @ToString.Exclude
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private LocalDate createdAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private Collection<Post> posts;

//    @NotNull
//    @Enumerated(EnumType.STRING) // passes the string value "ADMIN" to Hibernate instead of the integer index
//    private Role role = Role.ADMIN;

}
