package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl {

	@Autowired
	public UserServiceInt service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = (UserDTO) form.getDto();
		if (dto.getId() != null && dto.getId() > 0) {
			service.update(dto);
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = service.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		UserDTO dto = service.findById(id);
		res.addData(dto);
		return res;
	}

	@GetMapping("delete/{id}")
	public ORSResponse delete(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		service.delete(id);
		res.addMessage("data deleted successfully");
		return res;
	}

	@PostMapping("search")
	public ORSResponse search(@RequestBody UserForm form) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = (UserDTO) form.getDto();

		List list = service.search(dto, 0, 5);

		if (list.size() == 0) {
			res.addMessage("Result not found...!!!");
		} else {
			res.addData(list);
		}
		return res;
	}

}
