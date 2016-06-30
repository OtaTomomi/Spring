package board.mapper;

import java.util.List;

import board.dto.UserDto;
import board.entity.User;
import board.form.UserForm;

public interface UserMapper {
	User getUser(int id);
	List<User> getUserAll();
	int editUser(UserDto dto);
	int signupUser(UserForm userForm);
	User getUserInfomation(String loginId);
	int deleteUser(int id);
	int insertLoginTime(UserDto dto );
	int insertLogoutTime(String loginId);

}
