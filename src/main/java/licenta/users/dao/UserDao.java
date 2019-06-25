package licenta.users.dao;

import licenta.users.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserDto> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper() {} );
    }

    public void createUser(String firstName, String lastName, String email, String password) {
        jdbcTemplate.update(
            "INSERT INTO users(first_name, last_name, email, password) VALUES(?, ?, ?, ?)",
                firstName, lastName, email, password
        );
    }

    public void deleteUserById(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public void deleteUserByEmail(String email) {
        jdbcTemplate.update("DELETE FROM users WHERE email = ?", email);
    }

    public void updateUser(int id, String firstName, String lastName, String email, String password) {
        jdbcTemplate.update(
            "UPDATE users " +
            "SET first_name = ?, " +
            "    last_name = ?, " +
            "    email= ?, " +
            "    password = ? " +
            "WHERE id = ? ",
                firstName, lastName, email, password, id
        );
    }

    public UserDto login(String email, String password) {
        return jdbcTemplate.query("SELECT * FROM users WHERE email = ? AND password = ?", new UserRowMapper() {}, email, password ).get(0);
    }
}
