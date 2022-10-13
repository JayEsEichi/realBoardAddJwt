package sparta.project.realboard.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.project.realboard.Dto.LoginRequestDto;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="userid")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @Column(nullable = false)
    private LocalDateTime createdat;

    @Column(nullable = false)
    private LocalDateTime modifiedat;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.createdat = LocalDateTime.now();
        this.modifiedat = LocalDateTime.now();
    }
    public User(String username, String password, UserRoleEnum role){
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdat = LocalDateTime.now();
        this.modifiedat = LocalDateTime.now();
    }

    public User(LoginRequestDto loginRequestDto){
        this.username = loginRequestDto.getUsername();
        this.password = loginRequestDto.getPassword();
        this.createdat = LocalDateTime.now();
        this.modifiedat = LocalDateTime.now();
    }


}
