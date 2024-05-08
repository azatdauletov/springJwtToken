package kg.alima.SpringJwtToken.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kg.alima.SpringJwtToken.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}
