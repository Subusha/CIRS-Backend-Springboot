package cs.assignment.cirsbackend.mapper;

import cs.assignment.cirsbackend.dto.UserDto;
import cs.assignment.cirsbackend.entity.Users;

public class UserMapper {

    public static UserDto mapToUserDto(Users users){
        return new UserDto(
                users.getId(),
                users.getUsername(),
                users.getPassword(),
                users.getEmail(),
                users.isAdmin()
        );
    }

    public static Users mapToUsers(UserDto userDto){
        return new Users(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.isAdmin()
        );
    }

}
