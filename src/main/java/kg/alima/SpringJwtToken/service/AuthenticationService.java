package kg.alima.SpringJwtToken.service;

import kg.alima.SpringJwtToken.model.AuthenticationResponce;
import kg.alima.SpringJwtToken.model.User;
import kg.alima.SpringJwtToken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final JwtService jwtService;


    public AuthenticationResponce register(User request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUserName(request.getUserName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user = repository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthenticationResponce(token);
    }

    public AuthenticationResponce login(User request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        User user = repository.findByUserName(request.getUserName()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthenticationResponce(token);
    }
}
