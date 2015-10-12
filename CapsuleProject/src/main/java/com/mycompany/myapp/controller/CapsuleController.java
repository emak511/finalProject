package com.mycompany.myapp.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.mycompany.myapp.service.*;

@Controller
public class CapsuleController {

	private static final Logger logger = LoggerFactory.getLogger(CapsuleController.class);


	@RequestMapping("sub/friendlistwrapper")
	public String friendlistwrapper() {
		return "sub/friendlistwrapper";
	}
	
	@RequestMapping("sub/friendlistwrapper2")
	public String friendlistwrapper2() {
		return "sub/friendlistwrapper2";
	}
	
	@RequestMapping("sub/friendlistwrapper3")
	public String friendlistwrapper3() {
		return "sub/friendlistwrapper3";
	}
	
	@RequestMapping("sub/friendlistwrapper4")
	public String friendlistwrapper4() {
		return "sub/friendlistwrapper4";
	}
	
	@RequestMapping("sub/bottomlogobox")
	public String bottomlogobox() {
		return "sub/bottomlogobox";
	}
}
