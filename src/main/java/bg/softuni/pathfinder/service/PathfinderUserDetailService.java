package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.user.PathfinderUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PathfinderUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public PathfinderUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
    }

    private UserDetails map(User user) {
        return new PathfinderUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(this::map)
                        .toList()
        );
    }

    private GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getName().name());
    }
}
