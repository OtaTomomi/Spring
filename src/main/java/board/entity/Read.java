package board.entity;

public class Read {
	private int userId;
	private int readOrNot;
	private int messageId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReadOrNot() {
		return readOrNot;
	}
	public void setReadOrNot(int readOrNot) {
		this.readOrNot = readOrNot;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

}
