package demo.login.jwt.repository;
import demo.login.jwt.model.AuthenticationResponse;
import demo.login.jwt.model.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
}
