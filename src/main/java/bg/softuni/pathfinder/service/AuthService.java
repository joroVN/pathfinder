package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterDTO userRegisterDTO) {
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            throw new RuntimeException("password.match");
        }

        Optional<User> userOpt = userRepository.findByEmail(userRegisterDTO.getEmail());

        if (userOpt.isPresent()) {
            throw new RuntimeException("email.used");
        }

        User user = new User()
                .setUsername(userRegisterDTO.getUsername())
                .setFullName(userRegisterDTO.getFullName())
                .setAge(userRegisterDTO.getAge())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
