package licenta.users.controller;

import licenta.users.dto.UserDto;
import licenta.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired public UserService userService;

    public UserDto activeUser;
    public boolean logged;

    @PostMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public void createUser(String firstName, String lastName, String email, String password) {
        userService.createUser(firstName, lastName, email, password);
    }

    @PostMapping("/delete")
    public void deleteUserById(int id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/update")
    public void update(int id, String firstName, String lastName, String email, String password) {
        userService.updateUser(id, firstName, lastName, email, password);
    }

    @PostMapping("/login")
    public UserDto login(String email, String password) {

        if (userService.login(email, password) != null) {
            activeUser = userService.login(email, password);
            logged = true;
            return activeUser;
        } else {
            logged = false;
            return activeUser;
        }
    }

    @PostMapping("/logout")
    public void login() {
        if (logged = true) {
            activeUser = null;
            logged = false;
        }
    }

}
