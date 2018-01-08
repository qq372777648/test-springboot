package net.lzw.test.springboot.testspringboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import net.lzw.test.springboot.testspringboot.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = TestSpringbootApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@Transactional //2  测试后回滚
public class Ch104ApplicationTests {
	@Autowired
	DemoService demoService;
	
	MockMvc mvc;
	
	@Autowired 
	WebApplicationContext webApplicationContext;
	
	String expectedJson;
	
	@Before //3
	public void setUp() throws JsonProcessingException{ 
		//expectedJson =Obj2Json(personRepository.findAll()); //4
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	protected String Obj2Json(Object obj) throws JsonProcessingException{//5
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	@Test
	@Ignore
	public void testService() throws Exception {
	
		System.out.println(demoService.saySomething());
//		Assert.assertEquals("错误，正确的返回值为200",200, status); //9
//		Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson,content); //10
	}
	
	@Test
	public void testPersonController() throws Exception {
		String uri="/hello/json";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
																.andReturn(); //6
		int status = result.getResponse().getStatus(); //7
		String content = result.getResponse().getContentAsString(); //8
		System.out.println(status);
		
		System.out.println(content);
//		Assert.assertEquals("错误，正确的返回值为200",200, status); //9
//		Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson,content); //10
	}

}
