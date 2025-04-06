package demo.login.jwt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.login.jwt.model.AuthenticationResponse;
import demo.login.jwt.model.RegisterRequest;
import demo.login.jwt.model.User;
import demo.login.jwt.repository.JwtService;
import demo.login.jwt.service.AuthenticationSerrviceImpl;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationSerrviceImpl authenticationService;
    @PostMapping("/register")
     public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        AuthenticationResponse response = authenticationService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
     private final JwtService jwtService;
     
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Giả sử bạn đã xác thực người dùng ở đây
        return jwtService.generateToken(user);
    }
}
