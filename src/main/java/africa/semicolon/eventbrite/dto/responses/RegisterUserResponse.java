package africa.semicolon.eventbrite.dto.responses;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String email;
    private String dateCreated;
    private String statusMessage;
}
