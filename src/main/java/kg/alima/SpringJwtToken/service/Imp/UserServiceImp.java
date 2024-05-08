package kg.alima.SpringJwtToken.service.Imp;

import kg.alima.SpringJwtToken.dto.UserDto;
import kg.alima.SpringJwtToken.exception.ResourceNotFoundException;
import kg.alima.SpringJwtToken.mapper.UserMapper;
import kg.alima.SpringJwtToken.model.User;
import kg.alima.SpringJwtToken.repository.UserRepository;
import kg.alima.SpringJwtToken.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User userSaved = repository.save(user);
        return UserMapper.mapToUserDto(userSaved);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with given id: " + userId));
        return UserMapper.mapToUserDto(user);
    }


}
