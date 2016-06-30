package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.form.CommentForm;
import board.mapper.CommentMapper;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentMapper;

	public void insertComment(CommentForm commentForm) {
		commentMapper.insertComment(commentForm);
	}
	public int deleteComment(int id) {
		int count = commentMapper.deleteComment(id);
		return count;
	}
}
