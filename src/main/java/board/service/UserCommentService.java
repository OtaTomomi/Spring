package board.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.UserCommentDto;
import board.entity.UserComment;
import board.mapper.UserCommentMapper;

@Service
public class UserCommentService {
	@Autowired
	private UserCommentMapper userCommentMapper;

	public List<UserCommentDto> getUserCommentAll() {

		List<UserComment> userCommentList = userCommentMapper.getUserCommentAll();
		List<UserCommentDto> resultList = converToDto(userCommentList);
		return resultList;
	}

	public List<UserCommentDto> converToDto(List<UserComment> userCommentList) {
		List<UserCommentDto> resultList = new LinkedList<>();
		for (UserComment entity : userCommentList) {
			UserCommentDto dto = new UserCommentDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
	public List<UserCommentDto> getUserComment(int messageId){
		List<UserComment> userCommentList = userCommentMapper.getUserComment(messageId);
		List<UserCommentDto> resultList = converToDto(userCommentList);
		return resultList;
	}


}
