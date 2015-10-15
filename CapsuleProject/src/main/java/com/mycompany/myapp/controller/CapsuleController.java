package com.mycompany.myapp.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.mycompany.myapp.dto.*;
import com.mycompany.myapp.service.*;

@Controller
public class CapsuleController {

	private static final Logger logger = LoggerFactory.getLogger(CapsuleController.class);
	
	@Autowired
	private CapsuleService capsuleService;


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
	
	@RequestMapping("/bottomlogobox2")
	public String bottomlogobox22() {
		return "redirect:sub/bottomlogobox2";
	}
	
	@RequestMapping("sub/bottomlogobox2")
	public String bottomlogobox2(){
		return "sub/bottomlogobox2";
	}
	
	@RequestMapping("main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("main2")
	public String main2(Model model){
		List <Fcapsule> list  = capsuleService.getFcapsule("capsule@naver.com");
		model.addAttribute("list", list);
		return "main2";
	}
	
	@RequestMapping("sendtimecapsule")
	public String sendtimecapsule(){
		return "sub/sendtimecapsule";
	}
	
	@RequestMapping("viewtimecapsule")
	public String viewtimecapsule(){
		return "sub/viewtimecapsule";
	}
	
	
	
}
