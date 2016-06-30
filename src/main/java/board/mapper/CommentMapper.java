package board.mapper;

import board.form.CommentForm;

public interface CommentMapper {
int insertComment(CommentForm commentForm);
int deleteComment(int id);
}
