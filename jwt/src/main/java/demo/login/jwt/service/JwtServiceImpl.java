package demo.login.jwt.service;


import org.springframework.stereotype.Service;

import demo.login.jwt.model.User;
import demo.login.jwt.repository.JwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;
@Service
public class JwtServiceImpl implements JwtService{
   
        

        
    private static final String SECRET_KEY = 
    "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    @Override
    public String generateToken(User user) {
        return Jwts
                .builder()
                .setSubject(user.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
     private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    byte[] keyBytes = "555".getBytes(StandardCharsets.UTF_8);
SecretKey key = Keys.hmacShaKeyFor(keyBytes);
}
