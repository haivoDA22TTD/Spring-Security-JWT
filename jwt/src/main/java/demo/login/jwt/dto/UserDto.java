package demo.login.jwt.dto;


import java.util.Date;

import demo.login.jwt.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class UserDto {
        private Long id;
        private Long userId;
        private String username;
        private String firstName;
        private String lastName;
        private String name;
        private String email;
        private Date dateOfBirth;
        private String address;
        private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    
}
