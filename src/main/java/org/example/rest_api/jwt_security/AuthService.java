package org.example.rest_api.jwt_security;

import org.example.rest_api.user.User;
import org.example.rest_api.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String signup(String username, String rawPassword) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("User already exists");
        }
        User u = new User();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(rawPassword));
        userRepository.save(u);
        return jwtUtil.generateToken(username);
    }

    public String login(String username, String rawPassword) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, rawPassword)
        );
        if (auth.isAuthenticated()) {
            return jwtUtil.generateToken(username);
        }
        throw new BadCredentialsException("Invalid credentials");
    }
}
