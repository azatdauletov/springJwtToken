package kg.alima.SpringJwtToken.service;

import kg.alima.SpringJwtToken.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
}
