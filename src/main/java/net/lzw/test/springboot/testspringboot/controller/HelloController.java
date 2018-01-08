package net.lzw.test.springboot.testspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller//1
@RequestMapping("/hello")
public class HelloController {
	{
		System.out.println("hello bean create");
	}
	
	@RequestMapping("/index")//2
	public  String hello(){
		
		return "index";
	}
	
	@RequestMapping(value = "/json",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map getJson(final String p) {
		return new HashMap() {
			{
				put("reqParam", p);
				put("heh", "heheheheh");
			}
		};
	}

}
