package demo.login.jwt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Token {
    @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  @Column(unique = true)

    private Long userId;
    private String token;
    private boolean expired;
    private boolean revoked;

}
