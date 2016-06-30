package board.dto;

import java.util.Date;

public class UserCommentDto {
	private Integer commentId;
	private Integer messageId;
	private String commentText;
	private Date commentInsertDate;
	private String commentName;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentInsertDate() {
		return commentInsertDate;
	}
	public void setCommentInsertDate(Date commentInsertDate) {
		this.commentInsertDate = commentInsertDate;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

}
