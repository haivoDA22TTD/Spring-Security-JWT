package spring.jwt.refreshtoken.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.jwt.refreshtoken.config.JwtUtil;
import spring.jwt.refreshtoken.dto.AuthRequest;
import spring.jwt.refreshtoken.dto.AuthResponse;
import spring.jwt.refreshtoken.dto.RegisterRequest;
import spring.jwt.refreshtoken.entity.User;
import spring.jwt.refreshtoken.repository.UserRepository;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
      private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

     @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        userRepo.save(user);

        return ResponseEntity.ok("Registered successfully");
    }

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    User user = userRepo.findByUsername(request.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    if (!encoder.matches(request.getPassword(), user.getPassword())) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
    }

    String accessToken = jwtUtil.generateAccessToken(user.getUsername());
    String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());

    return ResponseEntity.ok(new AuthResponse(accessToken, refreshToken));
}

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {
        if (!jwtUtil.isTokenValid(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        String username = jwtUtil.extractUsername(refreshToken);
        String newAccessToken = jwtUtil.generateAccessToken(username);

        return ResponseEntity.ok(new AuthResponse(newAccessToken, refreshToken));
    }

    @GetMapping("/refresh")
public ResponseEntity<?> refreshTokenGet(@RequestParam String refreshToken) {
    if (!jwtUtil.isTokenValid(refreshToken)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
    }

    String username = jwtUtil.extractUsername(refreshToken);
    String newAccessToken = jwtUtil.generateAccessToken(username);

    return ResponseEntity.ok(new AuthResponse(newAccessToken, refreshToken));
}
}