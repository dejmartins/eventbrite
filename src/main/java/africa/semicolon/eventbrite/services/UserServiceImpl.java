package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.models.User;
import africa.semicolon.eventbrite.data.repositories.UserRepository;
import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        User savedUser = userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setStatusMessage("Thanks for joining us!");
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm a").format(savedUser.getLocalDateTime()));
        return response;
    }

    @Override
    public LoginUserResponse logIn(LoginUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found!"));
        LoginUserResponse response = new LoginUserResponse();
        if (user.getPassword().equals(request.getPassword())) {
            response.setStatusMessage("Login Successful");
        } else response.setStatusMessage("Invalid details");
        return response;
    }
}
