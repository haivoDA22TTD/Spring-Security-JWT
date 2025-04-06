package demo.login.jwt.repository;

import demo.login.jwt.model.User;

public interface JwtService {

    String generateToken(User user);
    
}
