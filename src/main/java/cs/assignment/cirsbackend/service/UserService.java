package cs.assignment.cirsbackend.service;

import cs.assignment.cirsbackend.dto.LoginDto;
import cs.assignment.cirsbackend.dto.UserDto;
import cs.assignment.cirsbackend.entity.Users;
import cs.assignment.cirsbackend.response.LoginMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto RegisterUsers(UserDto userDto);

    List<Users> GetAllUsers();

    /*

    Users LoginUser(UserDto userDto);

    String logUserNew(UserDto userDto);


     */
    LoginMessage loginUser(LoginDto loginDto);
}
