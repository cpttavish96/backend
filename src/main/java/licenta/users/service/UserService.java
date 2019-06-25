package licenta.users.service;

import licenta.users.dto.UserDto;
import licenta.users.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired public UserDao userDao;

    public List<UserDto> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void createUser(String firstName, String lastName, String email, String password) {
        userDao.createUser(firstName, lastName, email, password);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public void deleteUserByEmail(String email) {
        userDao.deleteUserByEmail(email);
    }

    public void updateUser(int id, String firstName, String lastName, String email, String password) {
        userDao.updateUser(id, firstName, lastName, email, password);
    }

    public UserDto login(String email, String password) {
        return userDao.login(email, password);
    }
}
