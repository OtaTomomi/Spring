package board.dto;

public class ReadDto {
private int userId;
private int messageId;
private int readOrNot;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getMessageId() {
	return messageId;
}
public void setMessageId(int messageId) {
	this.messageId = messageId;
}
public int getReadOrNot() {
	return readOrNot;
}
public void setReadOrNot(int readOrNot) {
	this.readOrNot = readOrNot;
}
}
