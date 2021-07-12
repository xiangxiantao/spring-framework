package com.xxt.spring.ioc.dependency.lookup;

import com.xxt.spring.ioc.annotation.LookupMe;
import com.xxt.spring.ioc.config.SimpleConfig;
import com.xxt.spring.ioc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 09:51
 **/
public class LookupDemo {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SimpleConfig.class);

		//根据名称查询bean
		//lookupByName(applicationContext);

		//根据类型查询bean
		//lookupByType(applicationContext);

		//查询具体类型的所有bean
		//lookupBeansOfType(applicationContext);

		//延迟加载
		//lazyLookup(applicationContext);

		//根据注解查找bean
		lookupByAnnotation(applicationContext);

	}

	/**
	 * 1.遍历beanDefinitionNames，查出每一个beanDefinition，保存存在相应注解的bd的beanName
	 * 2.对所有存在相应注解的bd，通过getBean(beanName)进行依赖查找
	 * @param applicationContext
	 */
	private static void lookupByAnnotation(AnnotationConfigApplicationContext applicationContext) {
		final Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(LookupMe.class);
		System.out.println(beansWithAnnotation);
	}

	/**
	 * 把resolveBean的结果用ObjectProvider封装起来，等到真正调用获取对象的方法时，才调用resolveBean进行真正的依赖查找，从而实现延迟查找
	 * @param applicationContext
	 */
	private static void lazyLookup(AnnotationConfigApplicationContext applicationContext) {
		final ObjectProvider<User> userProvider = applicationContext.getBeanProvider(User.class);
		System.out.println(userProvider.getIfAvailable());
	}

	/**
	 * 先查找类型对应的所有beanName，再根据每一个名称查找对应的bean，并封装成一个map
	 * @param applicationContext
	 */
	private static void lookupBeansOfType(AnnotationConfigApplicationContext applicationContext) {
		final Map<String, User> userMap = applicationContext.getBeansOfType(User.class);
		System.out.println(userMap);
	}

	/**
	 * 通过resolveBean，核心思路是先查找beanName，再通过getBean(beanName)查找bean
	 * 如果beanFactory没有查找到，从parentBeanFactory继续通过resolveBean查找
	 * @param applicationContext
	 */
	private static void lookupByType(AnnotationConfigApplicationContext applicationContext) {
		final User user1 = applicationContext.getBean(User.class);
		System.out.println(user1);
	}

	/**
	 * 如果是单例bean，直接通过getSingleton从singletonObjects中获取单例bean
	 * @param applicationContext
	 */
	private static void lookupByName(AnnotationConfigApplicationContext applicationContext) {
		final User user = (User) applicationContext.getBean("user");
		System.out.println(user);
	}

}
