package board.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.dto.UserDto;
import board.form.MessageForm;
import board.service.MessageService;
import board.service.UserService;

@Controller
public class PostController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home/post/", method = RequestMethod.GET)
	public String postMessage(Model model) {

		MessageForm messageForm = new MessageForm();
		model.addAttribute("messageForm", messageForm);
		return "postmessage";
	}

	@RequestMapping(value = "/home/post/", method = RequestMethod.POST)
	public String postMessage(@Valid @ModelAttribute MessageForm messageForm, BindingResult result, Model model,
			Principal principal) {
		if (result.hasErrors()) {
			return "postmessage";

		} else {
			final String nowLoginId = principal.getName();
			UserDto loginUser = new UserDto();
			loginUser = userService.getUserInfomation(nowLoginId);
			messageForm.setUserId(loginUser.getId());
			messageService.insertMessage(messageForm);
			return "redirect:/home/";
		}

	}

}
