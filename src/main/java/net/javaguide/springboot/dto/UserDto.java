package net.javaguide.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description = "UserDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @Schema(
            description = "User First Name"
    )
    //user first name should mot be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    @Schema(
            description = "User Last Name"
    )
    //user last name should mot be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;
    @Schema(
            description = "User Email Address"
    )
    //user email should mot be null or empty
    //email address should be valid
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "email address should be valid")
    private String email;
}
