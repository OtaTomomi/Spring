package board.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.dto.ReadDto;
import board.dto.UserCommentDto;
import board.dto.UserDto;
import board.dto.UserMessageDto;
import board.form.CommentForm;
import board.form.MessageForm;
import board.service.MessageService;
import board.service.ReadService;
import board.service.UserCommentService;
import board.service.UserMessageService;
import board.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserMessageService userMessageService;
	@Autowired
	private UserCommentService userCommentService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ReadService readService;

	@RequestMapping(value = "/home/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Principal principal, HttpSession session) {

		// ログインユーザー情報の取得
		final String nowLoginId = principal.getName();
		UserDto loginUser = new UserDto();
		loginUser = userService.getUserInfomation(nowLoginId);
		model.addAttribute("loginUser", loginUser);

		// 現在のセッションの開始時間の取得・表示
		Date loginTime = new Date(session.getCreationTime());
		model.addAttribute("loginTime", loginTime);

		// 最終ログイン時刻の取得・表示
		if (loginUser.getLoginTime() != null) {
			model.addAttribute("time", loginUser.getLoginTime());
		} else {
			model.addAttribute("time", "最初のログインです");
		}

		// コメントフォーム（コメント記入のため）（もういらない）
		CommentForm commentForm = new CommentForm();
		model.addAttribute("commentForm", commentForm);

		// メッセージフォーム（deleteのため）（必要か？）
		MessageForm messageForm = new MessageForm();
		model.addAttribute("messageForm", messageForm);

		// コメントの表示（もういらない）
		List<UserCommentDto> userComments = userCommentService.getUserCommentAll();
		model.addAttribute("userComments", userComments);

		// 記事の表示
		List<UserMessageDto> userMessages = userMessageService.getUserMessageAll();
		model.addAttribute("userMessages", userMessages);

		// 既読未読表示
		List<ReadDto> readLists = new ArrayList<ReadDto>();
		for (int i = 0; i < userMessages.size(); i++) {
			ReadDto readDto = new ReadDto();
			readDto.setMessageId(userMessages.get(i).getId());
			readDto.setUserId(loginUser.getId());
			int readCheck = readService.readOrNot(readDto);
			readDto.setReadCheck(readCheck);

			readLists.add(readDto);
		}
		model.addAttribute("readLists", readLists);

		return "home";
	}

	@RequestMapping(value = "/home/", method = RequestMethod.POST)
	public String home(@ModelAttribute MessageForm messageForm, Model model, Principal principal) {

		if (messageForm.getId() != null) {
			System.out.println("実行A");
			System.out.println(messageForm.getId());

			int count = messageService.deleteMessage(messageForm.getId());
			System.out.println("削除件数は" + count + "件です");

		}
		return "redirect:/home/";
	}

	// ログイン認証系処理
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Locale locale, Model model) {
		return "error";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String permission(Locale locale, Model model) {

		return "403";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, Principal principal, HttpSession session) {
		final String nowLoginId = principal.getName();
		UserDto loginUser = new UserDto();
		loginUser = userService.getUserInfomation(nowLoginId);
		Date loginTime = new Date(session.getCreationTime());
		loginUser.setLoginTime(loginTime);
		userService.insertLoginTime(loginUser);

		session.invalidate(); // セッションの無効化

		return "redirect:/login";
	}

}
