package spring.security.token.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenvalid(String token, UserDetails  userDetails);
}
