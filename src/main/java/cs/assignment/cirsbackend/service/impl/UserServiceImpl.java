package cs.assignment.cirsbackend.service.impl;

import cs.assignment.cirsbackend.dto.LoginDto;
import cs.assignment.cirsbackend.dto.UserDto;
import cs.assignment.cirsbackend.entity.Users;
import cs.assignment.cirsbackend.mapper.UserMapper;
import cs.assignment.cirsbackend.repository.UserRepository;
import cs.assignment.cirsbackend.response.LoginMessage;
import cs.assignment.cirsbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDto RegisterUsers(UserDto userDto) {
        Users users = UserMapper.mapToUsers(userDto);
        this.passwordEncoder.encode(userDto.getPassword());
        Users registeredUser = userRepository.save(users);
        // Set isAdmin based on userDto (if needed)
        users.setAdmin(false);
        return UserMapper.mapToUserDto(registeredUser);
    }

    /*

    @Override
    public Users LoginUser(UserDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();

        Users foundUser = userRepository.findByEmail(email);
        if(foundUser.getPassword() == password){
            return foundUser;
        }
        return foundUser;
    }

    @Override
    public String logUserNew(UserDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();

        Users foundUser = userRepository.findByEmail(email);
        if(Objects.equals(foundUser.getPassword(), password)){
            return "Successfully Logged in";
        }
        else {
            return "Wrong User name or Password";
        }
    }
*/

    @Override
    public List<Users> GetAllUsers() {
        List<Users> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public LoginMessage loginUser(LoginDto loginDto){

        String msg = "";
        Users user1 = userRepository.findByEmail(loginDto.getEmail());
        if(user1 != null){
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Bool ean isPasswordRight = passwordEncoder.matches(password,encodedPassword);
            if(isPasswordRight){
                Optional<Users> users = userRepository.findOneByEmailAndPassword(loginDto.getEmail(),encodedPassword);
                if(users.isPresent()){
                    return new LoginMessage("Login Successful", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Incorrect Password", false);
            }
        } else {
            return new LoginMessage("Email does not exists", false);
        }
    }
}
