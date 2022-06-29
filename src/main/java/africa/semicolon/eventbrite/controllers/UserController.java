package africa.semicolon.eventbrite.controllers;

import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest request){
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginUserResponse logIn(@RequestBody LoginUserRequest request){
        return userService.logIn(request);
    }
}
