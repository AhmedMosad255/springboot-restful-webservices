package net.javaguide.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguide.springboot.dto.UserDto;
import net.javaguide.springboot.exception.ErrorDetails;
import net.javaguide.springboot.exception.RecourseNotFoundException;
import net.javaguide.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name = "CRUD REST APIs for Resources",
        description = "CRUD REST APIs -> Create User, Delete User, Get User,Get All Users"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @Operation(
            summary = "Create User REST API ",
            description = "Create User REST API is used to saved user in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED "
    )
    //build create user rest api
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get User REST API ",
            description = "Get User REST API is used to Get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success "
    )
    //build get userById rest api
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @Operation(
            summary = "Get All User REST API ",
            description = "Get All User REST API is used to Get all user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success "
    )
    //build get all users rest api
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
       List<UserDto> users =  userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @Operation(
            summary = "Update All User REST API ",
            description = "Update All User REST API is used to Update user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success "
    )
    //build update user rest api
    @PutMapping("{id}")
    public ResponseEntity<UserDto> UpdateUser(@PathVariable("id") Long userId,@RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @Operation(
            summary = "Delete All User REST API ",
            description = "Delete All User REST API is used to Delete user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success "
    )
    //build delete user rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully Deleted", HttpStatus.OK);
    }
//    @ExceptionHandler(RecourseNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handelRecourseNotFoundException(RecourseNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),"USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
