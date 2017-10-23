package com.example.uts1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/master")
	public String master() {
		return "layout/master";
	}

	@RequestMapping("/sumber")
	public String sumber() {
		return "layout/sumber";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
