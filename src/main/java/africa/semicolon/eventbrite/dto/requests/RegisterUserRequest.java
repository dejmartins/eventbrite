package africa.semicolon.eventbrite.dto.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterUserRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
