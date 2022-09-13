package ryanyoshimura.restfulblog.data;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private long id;
    private String userName;

    @Email
    @NotEmpty
    private String email;

    @ToString.Exclude
    private String password;
    private LocalDate createdAt;
    private UserRole role;

    private Collection<Post> posts;

//    @NotNull
//    @Enumerated(EnumType.STRING) // passes the string value "ADMIN" to Hibernate instead of the integer index
//    private Role role = Role.ADMIN;

}
