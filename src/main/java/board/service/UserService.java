package board.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import board.dto.UserDto;
import board.entity.User;
import board.form.UserForm;
import board.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	protected StandardPasswordEncoder passwordEncoder;

	public List<UserDto> getUserAll() {
		List<User> userList = userMapper.getUserAll();
		List<UserDto> resultList = converToDto(userList);
		return resultList;

	}
	public UserDto getUser(Integer id) {
		UserDto dto = new UserDto();
		User entity = userMapper.getUser(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	public UserDto getUserInfomation(String loginId) {
		UserDto dto = new UserDto();
		User entity = userMapper.getUserInfomation(loginId);
		BeanUtils.copyProperties(entity, dto);
		return dto;


	}

	public List<UserDto> converToDto(List<User> userList) {
		List<UserDto> resultList = new LinkedList<>();
		for (User entity : userList) {
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
	public void editUser(UserDto dto,String rawPassword) {

		String password = passwordEncoder.encode(rawPassword);
		dto.setPassword(password);
		userMapper.editUser(dto);

		//throw new RuntimeException();
	}
	public void signupUser(UserForm userForm,String rawPassword){
		String password = passwordEncoder.encode(rawPassword);
		userForm.setPassword(password);
		userMapper.signupUser(userForm);
	}
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}
	public void insertLoginTime(UserDto userDto){
		userMapper.insertLoginTime(userDto );
	}
	public void insertLogoutTime(String loginId){
		userMapper.insertLogoutTime(loginId);
	}
}
