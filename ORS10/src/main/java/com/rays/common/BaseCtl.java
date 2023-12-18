package com.rays.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

	@Autowired
	public S baseService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody F form) {

		ORSResponse res = new ORSResponse(true);

		T dto = (T) form.getDto();

		long pk = baseService.save(dto);

		res.addMessage("User Registered Successfully..!!!");
		res.addData("hello");
		res.addResult("token", "123ghcgc");

		return res;
	}

}
