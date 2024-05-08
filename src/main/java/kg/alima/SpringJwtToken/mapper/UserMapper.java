package kg.alima.SpringJwtToken.mapper;

import kg.alima.SpringJwtToken.dto.UserDto;
import kg.alima.SpringJwtToken.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getRole()
        );
    }
}
