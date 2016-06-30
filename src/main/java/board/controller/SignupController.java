package board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.dto.BranchDto;
import board.dto.PositionDto;
import board.form.UserForm;
import board.service.BranchService;
import board.service.PositionService;
import board.service.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/user/signup/", method = RequestMethod.GET)
	public String userSignup(Model model) {
		UserForm userForm = new UserForm();
		List<PositionDto> positions = positionService.getPositionAll();
		List<BranchDto> branches = branchService.getBranchAll();
		model.addAttribute("branches", branches);
		model.addAttribute("positions", positions);
		model.addAttribute("userForm", userForm);
		return "signup";
	}

	@RequestMapping(value = "/user/signup/", method = RequestMethod.POST)
	public String userSignup(@Valid @ModelAttribute UserForm userForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<PositionDto> positions = positionService.getPositionAll();
			List<BranchDto> branches = branchService.getBranchAll();
			model.addAttribute("branches", branches);
			model.addAttribute("positions", positions);
			model.addAttribute("userForm", userForm);
			return "signup";

		} else {
			userService.signupUser(userForm, userForm.getPassword());

			return "redirect:/user/";

		}
	}

}
