package net.javaguide.springboot.mapper;

import net.javaguide.springboot.entity.User;
import net.javaguide.springboot.dto.UserDto;

public class UserMapper {
    //Convert User JPA Entity into userDto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
    //convert userDto into user JPA Entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
