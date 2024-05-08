package kg.alima.SpringJwtToken.service.Imp;

import kg.alima.SpringJwtToken.dto.UserDto;
import kg.alima.SpringJwtToken.exception.ResourceNotFoundException;
import kg.alima.SpringJwtToken.mapper.UserMapper;
import kg.alima.SpringJwtToken.model.User;
import kg.alima.SpringJwtToken.repository.UserRepository;
import kg.alima.SpringJwtToken.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User userSaved = repository.save(user);
        return UserMapper.mapToUserDto(userSaved);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with given id: " + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user) )
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = repository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with given id: " + userId));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setUserName(updatedUser.getUserName());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setRole(updatedUser.getRole());
        User updatedUserObj = repository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }


}
