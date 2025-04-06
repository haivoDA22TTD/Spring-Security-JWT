package demo.login.jwt.repository;

import org.springframework.stereotype.Repository;

import demo.login.jwt.model.User;
@Repository
public interface UserRepository {
    User findByUserName(String username);

    User save(User newUser);
    }

