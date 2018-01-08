package net.lzw.test.springboot.testspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.lzw.test.springboot.testspringboot.pojo.Person;

/** 
* @author: liangzhenwei
* @create：2018年1月4日 下午5:37:00 
* @company:广州荔支网络技术有限公司
*/
@Controller
@RequestMapping("/Thymeleaf")
public class ThymeleafTestController {
	//http://localhost/test-springboot/Thymeleaf/index
	@RequestMapping("/index")
	public String index(Model model){
		Person single = new Person("aa",11);
		
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("xx",11);
		Person p2 = new Person("yy",22);
		Person p3 = new Person("zz",33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		
		return "index";
	}

}
