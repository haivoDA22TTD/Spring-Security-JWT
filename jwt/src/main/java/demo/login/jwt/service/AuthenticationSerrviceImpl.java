package demo.login.jwt.service;

import org.springframework.stereotype.Service;
import demo.login.jwt.mapper.UserMapper;
import demo.login.jwt.repository.AuthenticationService;
import demo.login.jwt.repository.TokenRepository;
import demo.login.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import demo.login.jwt.model.*;


@Service
@RequiredArgsConstructor
public class AuthenticationSerrviceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository; // thêm TokenRepository
    private final JwtServiceImpl jwtService;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        // Khởi tạo User mới
         User newUser = new User();
        
        // Gọi đúng các getter từ RegisterRequest
       
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());
            newUser.setEmail(request.getEmail());

        // Lưu User vào cơ sở dữ liệu
        User createdUser = userRepository.save(newUser);

        // Tạo JWT token
        String jwtToken = jwtService.generateToken(createdUser);

        // Lưu token vào database
        Token token = Token.builder()
                .userId(createdUser.getUserId())  // Lấy userId từ user đã lưu
                .token(jwtToken)
                .expired(false)  // Cần phải xác định token có hết hạn không
                .revoked(false)  // Cần phải xác định token có bị thu hồi không
                .build();
        
        // Lưu token vào cơ sở dữ liệu
        tokenRepository.save(token);

        // Trả về AuthenticationResponse bao gồm userDto và token
        return AuthenticationResponse.builder()
                .userDto(UserMapper.mapToUserDto(createdUser))  // Dùng UserMapper để chuyển đổi
                .token(jwtToken)
                .build();
    }
}
