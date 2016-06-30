package board.mapper;
import board.form.MessageForm;

public interface MessageMapper {
	int insertMessage(MessageForm messageForm);
	int deleteMessage(int id);

}
