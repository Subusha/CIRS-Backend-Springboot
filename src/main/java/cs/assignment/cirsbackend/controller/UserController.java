package cs.assignment.cirsbackend.controller;

import cs.assignment.cirsbackend.dto.LoginDto;
import cs.assignment.cirsbackend.dto.UserDto;
import cs.assignment.cirsbackend.entity.Users;
import cs.assignment.cirsbackend.response.LoginMessage;
import cs.assignment.cirsbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    //Build Register User REST API
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto registeredUser = userService.RegisterUsers(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

/*
    //Build LOGIN User REST API
    @PostMapping("/login1")
    public ResponseEntity<Users> logUser(@RequestBody UserDto userDto) {
        Users loggedUser = userService.LoginUser(userDto);
        return new ResponseEntity<>(loggedUser, HttpStatus.ACCEPTED);
    }

    //Build LOGIN User REST API
    @PostMapping("/login-new")
    public String logUserNew(@RequestBody UserDto userDto) {
        return userService.logUserNew(userDto);
    }
*/

    //Build LOGIN User REST API
    @PostMapping("/login")
    public ResponseEntity<?> loginUser (@RequestBody LoginDto loginDto){
        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }

    //Build Get All User REST API
    @GetMapping("/get-all-users")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> usersList = userService.GetAllUsers();
        return ResponseEntity.ok(usersList);
    }

}
