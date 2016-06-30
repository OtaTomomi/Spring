package board.mapper;

import java.util.List;

import board.entity.UserComment;

public interface UserCommentMapper {
	List<UserComment> getUserCommentAll();
	List<UserComment> getUserComment(int messageId);


}
