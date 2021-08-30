package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String demo() {
		return "This is Not a jsp pages";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}
