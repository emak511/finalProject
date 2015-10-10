package com.mycompany.myapp.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.mycompany.myapp.service.*;

@Controller
public class CapsuleController {

	private static final Logger logger = LoggerFactory.getLogger(CapsuleController.class);

	
	@RequestMapping("friendlistwrapper")
	public String login() {
		return "friendlistwrapper";
}
	
}
