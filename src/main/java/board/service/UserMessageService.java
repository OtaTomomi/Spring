package board.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.UserMessageDto;
import board.entity.UserMessage;
import board.mapper.UserMessageMapper;

@Service
public class UserMessageService {
	@Autowired
	private UserMessageMapper userMessageMapper;

	public List<UserMessageDto> getUserMessageAll() {
		List<UserMessage> userMessageList = userMessageMapper.getUserMessageAll();
		List<UserMessageDto> resultList = converToDto(userMessageList);
		return resultList;
	}
	public List<UserMessageDto> converToDto(List<UserMessage> userMessageList){
		List<UserMessageDto> resultList = new LinkedList<>();
		for(UserMessage entity : userMessageList){
			UserMessageDto dto = new UserMessageDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
	public UserMessageDto getUserMessage(int id) {
		List<UserMessage> userMessage = userMessageMapper.getUserMessage(id);
		List<UserMessageDto> resultList = converToDto(userMessage);

		return resultList.get(0);
	}
}
