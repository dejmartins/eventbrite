package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest request);
    LoginUserResponse logIn(LoginUserRequest request);
}
