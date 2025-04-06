package demo.login.jwt.mapper;
import demo.login.jwt.dto.UserDto;
import demo.login.jwt.model.User;

public class UserMapper {
     public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
