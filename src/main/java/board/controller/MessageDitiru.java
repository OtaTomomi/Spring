package board.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.dto.ReadDto;
import board.dto.UserCommentDto;
import board.dto.UserDto;
import board.dto.UserMessageDto;
import board.form.CommentForm;
import board.form.MessageForm;
import board.service.CommentService;
import board.service.MessageService;
import board.service.ReadService;
import board.service.UserCommentService;
import board.service.UserMessageService;
import board.service.UserService;

@Controller
public class MessageDitiru {
	@Autowired
	private UserMessageService userMessageService;
	@Autowired
	private UserCommentService userCommentService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ReadService readService;


	@RequestMapping(value = "/home/detiru/{id}", method = RequestMethod.GET)
	public String messageDitiru(Locale locale, Model model, Principal principal, @PathVariable int id) {
		// 本文表示
		UserMessageDto messageDto = userMessageService.getUserMessage(id);
		model.addAttribute("userMessage", messageDto);
		// コメント表示
		List<UserCommentDto> commentList = userCommentService.getUserComment(id);
		model.addAttribute("userComments", commentList);

		CommentForm commentForm = new CommentForm();
		model.addAttribute("commentForm", commentForm);

		MessageForm messageForm = new MessageForm();
		model.addAttribute("messageForm", messageForm);

		//閲覧中のユーザー情報を取得
		final String nowLoginId = principal.getName();
		UserDto loginUser = new UserDto();
		loginUser = userService.getUserInfomation(nowLoginId);
		model.addAttribute("loginUser", loginUser);

		//未読既読判定
		ReadDto readDto = new ReadDto();
		readDto.setMessageId(id);
		readDto.setUserId(loginUser.getId());
		int readOrNot = readService.readOrNot(readDto);
		if(readOrNot == 1){
			return "messageditiru";
		}else{
			readService.alreadyRead(readDto);
			return "messageditiru";
		}
	}
	@RequestMapping(value = "/home/detiru/{id}",method = RequestMethod.POST )
	public String messageDitiru(@Valid @ModelAttribute CommentForm commentForm, BindingResult result,
			 Model model, Principal principal){
		final String nowLoginId = principal.getName();
		UserDto loginUser = new UserDto();
		loginUser = userService.getUserInfomation(nowLoginId);
		model.addAttribute("loginUser", loginUser);

		if(commentForm.getText() == null){

			int count = commentService.deleteComment(commentForm.getId());
			System.out.println("削除件数は" + count + "件です");
		}



		if (commentForm.getText() != null) {


			if (result.hasErrors()) {

			} else {
				commentForm.setUserId(loginUser.getId());
				commentService.insertComment(commentForm);


			}

		}
		return "redirect:/home/detiru/{id}";
	}
}
