package licenta.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import licenta.users.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserDto>
{
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getInt("id"));
        userDto.setFirstName(rs.getString("first_name"));
        userDto.setLastName(rs.getString("last_name"));
        userDto.setEmail(rs.getString("email"));
        userDto.setPassword(rs.getString("password"));
        return userDto;
    }

}