package demo.login.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.login.jwt.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{

}
