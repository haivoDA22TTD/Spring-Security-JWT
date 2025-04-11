package spring.jwt.refreshtoken.config;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final String SECRET = "my_super_secret_jwt_key_1234567890";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Value("${jwt.refresh_expiration}")
    private long refreshExpiration;

    public String generateToken(String username, long expiration) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(key, SignatureAlgorithm.HS256) 
            .compact();
    }

    public String generateAccessToken(String username) {
        return generateToken(username, jwtExpiration);
    }

    public String generateRefreshToken(String username) {
        return generateToken(username, refreshExpiration);
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key) 
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
