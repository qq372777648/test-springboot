package net.lzw.test.springboot.testspringboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AliasFor;

/** 
* @author: liangzhenwei
* @create：2018年1月4日 下午2:20:49 
* @company:广州荔支网络技术有限公司
*/
public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		SpringBootApplication  a=TestSpringbootApplication.class.getAnnotation(SpringBootApplication.class);
		System.out.println(a);
		System.out.println(a.annotationType().getAnnotations().length);
		System.out.println(a.annotationType().getAnnotation(SpringBootConfiguration.class));
		System.out.println(a.annotationType().getDeclaredMethod("scanBasePackages").getAnnotation(AliasFor.class));
//		a.annotationType().
		
		SpringBootConfiguration a2=a.annotationType().getAnnotation(SpringBootConfiguration.class);
		System.out.println(a2);
	}

}
