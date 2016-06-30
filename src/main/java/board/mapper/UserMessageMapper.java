package board.mapper;

import java.util.List;

import board.entity.UserMessage;

public interface UserMessageMapper {
	List<UserMessage> getUserMessageAll();
	List<UserMessage> getUserMessage(int id);

}
