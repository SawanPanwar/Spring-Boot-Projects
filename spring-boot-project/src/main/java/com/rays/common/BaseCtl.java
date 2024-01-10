package com.rays.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

	@Autowired
	public S baseService;

	@GetMapping("test")
	public ORSResponse test() {
		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		errors.put("loginId", "login is required");
		errors.put("password", "password is required");

		res.addInputError(errors);

		res.addMessage("message added successfully");

		res.addData("data");

		res.addResult("list", "rolelist");
		return res;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody F form) {
		ORSResponse res = new ORSResponse();
		T dto = (T) form.getDto();
		if (dto.getId() != null && dto.getId() > 0) {
			baseService.update(dto);
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = baseService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		T dto = baseService.findById(id);
		res.addData(dto);
		return res;
	}

	@GetMapping("delete/{id}")
	public ORSResponse delete(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		baseService.delete(id);
		res.addMessage("data deleted successfully");
		return res;
	}
}
