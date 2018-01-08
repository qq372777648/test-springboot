package net.lzw.test.springboot.testspringboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**   
* @author lzw   
* @date 2016年10月19日 下午3:55:19 
* @Description: 
* @version V1.0   
*/
//采用xml方式 加入ioc
//@Component
//@Lazy(false)
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 获取ApplicationContext
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 按名称获取spring bean实例
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 按类型获取spring bean 实例
	 * 
	 * @param beanType
	 * @return
	 */
	public static <T> T getBean(Class<T> beanType) {
		return applicationContext.getBean(beanType);
	}
}



