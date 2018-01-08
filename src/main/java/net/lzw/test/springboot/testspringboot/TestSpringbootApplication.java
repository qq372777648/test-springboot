package net.lzw.test.springboot.testspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.lzw.test.springboot.testspringboot.bean.SpringContextUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@SpringBootApplication
@ImportResource({ "classpath:applicationContext.xml" }) // 导入xml配置项
@Component
@RestController
@ConfigurationProperties(prefix = "learner") // application learner.* 自动同名注入 ,need setter
public class TestSpringbootApplication {

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;

	private String name;// application learner.name

	private String Like;

	@RequestMapping("/")
	String index() {
		System.out.println(SpringContextUtil.getBean(TestSpringbootApplication.class).getBookName());
		System.out.println(SpringContextUtil.getBean(TestSpringbootApplication.class).name);
		System.out.println(SpringContextUtil.getBean(TestSpringbootApplication.class).Like);
		System.out.println(name);
		System.out.println(Like);
		return "book name is:" + bookName + " and book author is:" + bookAuthor;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootApplication.class, args);
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLike() {
		return Like;
	}

	public void setLike(String like) {
		Like = like;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	

}
