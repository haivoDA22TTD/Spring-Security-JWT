package spring.jwt.refreshtoken.dto;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;

    private String password;
}
