package kg.alima.SpringJwtToken.service;

import kg.alima.SpringJwtToken.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
}
