package org.example.rest_api.jwt_security;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@Valid @RequestBody SignupRequest req) {
        String token = authService.signup(req.username(), req.password());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest req) {
        String token = authService.login(req.username(), req.password());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}

@RestController
@RequestMapping("/api/hello")
class HelloController {
    @GetMapping
    public Map<String, String> hello(Authentication auth) {
        return Map.of("message", "Hello, " + auth.getName());
    }
}

record SignupRequest(@NotBlank String username, @NotBlank String password) {}

record LoginRequest(@NotBlank String username, @NotBlank String password) {}

record JwtResponse(String token) {}