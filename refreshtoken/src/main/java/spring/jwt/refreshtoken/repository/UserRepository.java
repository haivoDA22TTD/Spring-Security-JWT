package spring.jwt.refreshtoken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.jwt.refreshtoken.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
}
