package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.form.MessageForm;
import board.mapper.MessageMapper;

@Service
public class MessageService {

	@Autowired
	private  MessageMapper messageMapper;

	public void insertMessage(MessageForm messageForm) {
		messageMapper.insertMessage(messageForm);
	}
	public int deleteMessage(int id) {
		int count = messageMapper.deleteMessage(id);
		return count;

	}
}
