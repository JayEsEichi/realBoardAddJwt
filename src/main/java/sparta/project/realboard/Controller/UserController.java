package sparta.project.realboard.Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sparta.project.realboard.Dto.LoginRequestDto;
import sparta.project.realboard.Dto.UserRequestDto;
import sparta.project.realboard.Entity.User;
import sparta.project.realboard.Jwt.JwtProperties;
import sparta.project.realboard.Repository.UserRepository;
import sparta.project.realboard.Security.UserDetailsImpl;
import sparta.project.realboard.Service.UserService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/user/register")
    public void registeraccount (@RequestBody UserRequestDto userRequestDto) {
        userService.registeraccount(userRequestDto);
    }

    // 유저 혹은 매니저 혹은 어드민이 접근 가능
    @PostMapping("/user/login")
    public User userlogin(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        System.out.println(response.getHeader(JwtProperties.HEADER_STRING));
//        System.out.println("userDetails = " + userDetails.getUser());
//        System.out.println("response = " + response);

        return userService.userlogin(loginRequestDto, response, userDetails.getUser());
    }

    // authentication
    // @AuthenticationPrincipal UserDetailsImpl

    // 임시 회원 조회
    @GetMapping("/user/{id}")
    public Optional<User> userfind(@PathVariable Long id,HttpServletResponse response) {
//        System.out.println("리스폰스 확인 = " + response.getHeader(JwtProperties.HEADER_STRING));
        return userRepository.findById(id);
    }


}
