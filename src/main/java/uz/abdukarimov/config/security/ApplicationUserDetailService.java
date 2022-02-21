package uz.abdukarimov.config.security;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.abdukarimov.entity.user.AuthUser;
import uz.abdukarimov.repository.UserRepository;


@Getter
@Service
public class ApplicationUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private Long id;

    public ApplicationUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository.findAuthUserByUsername(username);
        if (authUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        id = authUser.getId();
        return User.builder()
                .username(authUser.getUsername())
                .password(authUser.getPassword())
                .roles(authUser.getRole().getName())
                .authorities(authUser.getRole().getAuthorities())
                .build();
    }
}
