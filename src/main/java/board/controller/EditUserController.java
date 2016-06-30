package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class EditUserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/user/edituser/{id}", method = RequestMethod.GET)
	public String editUser(Model model, @PathVariable int id) {
		UserDto user = userService.getUser(id);
		model.addAttribute("message", user.getName() + "の編集");
		model.addAttribute("user", user);
		UserForm userForm = new UserForm();
		userForm.setId(user.getId());
		userForm.setLoginId(user.getLoginId());
		List<PositionDto> positions = positionService.getPositionAll();
		List<BranchDto> branches = branchService.getBranchAll();
		model.addAttribute("branches", branches);
		model.addAttribute("positions", positions);
		userForm.setName(user.getName());
		userForm.setBranchId(user.getBranchId());
		userForm.setPositionId(user.getPositionId());
		model.addAttribute("userForm", userForm);
		return "edituser";
	}

	@RequestMapping(value = "/user/edituser/{id}",method = RequestMethod.POST)
	public String editUser(@Valid @ModelAttribute UserForm userForm,BindingResult result, Model model,@PathVariable int id,
			HttpSession session){
		if(result.hasErrors()){
			UserDto user = userService.getUser(id);
			model.addAttribute("message", user.getName() + "の編集");
			model.addAttribute("userForm", userForm);
			List<PositionDto> positions = positionService.getPositionAll();
			List<BranchDto> branches = branchService.getBranchAll();
			model.addAttribute("branches", branches);
			model.addAttribute("positions", positions);
			return "edituser";

		} else {
			try{
				UserDto dto = new UserDto();
				BeanUtils.copyProperties(userForm, dto);
				userService.editUser(dto,dto.getPassword());

			}catch(RuntimeException e){

				session.setAttribute("errorMessage", "他の人によって更新されています。最新のデータを確認してください");


			}
			return "redirect:/user/";




		}
	}

}
