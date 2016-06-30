package board.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.dto.BranchDto;
import board.dto.PositionDto;
import board.dto.UserDto;
import board.form.UserForm;
import board.service.BranchService;
import board.service.PositionService;
import board.service.UserService;

@Controller
public class UserListController {

	@Autowired
	private UserService userService;
	@Autowired
	private BranchService branchServce;
	@Autowired
	private PositionService positionService;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String userList(Locale locale, Model model, Principal principal) {
		final String nowLoginId = principal.getName();
		UserDto loginUser = new UserDto();
		loginUser = userService.getUserInfomation(nowLoginId);
		List<UserDto> users = userService.getUserAll();
		List<BranchDto> branches = branchServce.getBranchAll();
		List<PositionDto> positions = positionService.getPositionAll();
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("positions", positions);
		model.addAttribute("branches", branches);
		model.addAttribute("users", users);
		return "userList";

	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public String userList(@ModelAttribute UserForm userForm, Locale locale, Model model) {
		userService.deleteUser(userForm.getId());
		return "redirect:/user/";
	}

}
