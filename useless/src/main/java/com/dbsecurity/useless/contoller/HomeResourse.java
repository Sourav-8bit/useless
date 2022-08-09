package com.dbsecurity.useless.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeResourse {
	
	
	
	
	
	@GetMapping("/qqq")
	public String GetMessage()
	{
		return "yadav";
	}

	@GetMapping("/user")
	public String user()
	{
	return "welcome sourav";
	}


	@GetMapping("/admin")
	public String admin()
	{
		return "star player";
	}

	}


