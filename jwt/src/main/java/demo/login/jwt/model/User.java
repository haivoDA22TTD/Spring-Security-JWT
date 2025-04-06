package demo.login.jwt.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Đảm bảo chỉ sử dụng @GeneratedValue cho userId
    private Long userId;  // userId là khóa chính

    private String name;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;
}
