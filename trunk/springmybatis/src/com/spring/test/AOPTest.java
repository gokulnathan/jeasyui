package com.spring.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.service.AService;
import com.spring.service.BServiceImpl;

public class AOPTest extends TestCase {
	private AService aService;
	private BServiceImpl bService;

	protected String[] getConfigLocations() {
		String[] configs = new String[] { "/applicationContext.xml" };
		return configs;
	}
	
	public static ApplicationContext init() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/applicationContext.xml");
		
		return ctx;
	}

	/**
	 * 测试正常调用
	 */
	@Test
	public void testCall() {
		ApplicationContext ctx = init();
		aService = (AService) ctx.getBean("aService");
		bService = (BServiceImpl) ctx.getBean("bService");
		
		System.out.println("SpringTest JUnit test");
		aService.fooA("JUnit test fooA");
		/*aService.barA();
		bService.fooB();
		bService.barB("JUnit test barB", 0);*/
	}

	/**
	 * 测试After-Throwing
	 */
	public void testThrow() {
		ApplicationContext ctx = init();
		bService = (BServiceImpl) ctx.getBean("bService");
		try {
			bService.barB("JUnit call barB", 1);
		} catch (IllegalArgumentException e) {

		}
	}

	public void setAService(AService service) {
		aService = service;
	}

	public void setBService(BServiceImpl service) {
		bService = service;
	}
	
	/*
	 * 《Spring参考手册》中定义了以下几个AOP的重要概念，结合以上代码分析如下：
	 * 
	 * 切面（Aspect）
	 * ：官方的抽象定义为“一个关注点的模块化，这个关注点可能会横切多个对象”，在本例中，“切面”就是类TestAspect所关注的具体行为
	 * ，例如，AServiceImpl
	 * .barA()的调用就是切面TestAspect所关注的行为之一。“切面”在ApplicationContext中<aop:aspect>来配置。
	 * 连接点（Joinpoint）
	 * ：程序执行过程中的某一行为，例如，AServiceImpl.barA()的调用或者BServiceImpl.barB(String _msg,
	 * int _type)抛出异常等行为。 通知（Advice）
	 * ：“切面”对于某个“连接点”所产生的动作，例如，TestAspect中对com.spring
	 * .service包下所有类的方法进行日志记录的动作就是一个Advice。其中，一个“切面”可以包含多个“Advice”，例如TestAspect
	 * 切入点（Pointcut）
	 * ：匹配连接点的断言，在AOP中通知和一个切入点表达式关联。例如，TestAspect中的所有通知所关注的连接点，都由切入点表达式execution
	 * (* com.spring.service.*.*(..))来决定 目标对象（Target Object）
	 * ：被一个或者多个切面所通知的对象。例如，AServcieImpl和BServiceImpl，当然在实际运行时，Spring
	 * AOP采用代理实现，实际AOP操作的是TargetObject的代理对象。 AOP代理（AOP Proxy） 在Spring
	 * AOP中有两种代理方式
	 * ，JDK动态代理和CGLIB代理。默认情况下，TargetObject实现了接口时，则采用JDK动态代理，例如，AServiceImpl
	 * ；反之，采用CGLIB代理，例如，BServiceImpl。强制使用CGLIB代理需要将 <aop:config> 的
	 * proxy-target-class 属性设为true
	 */

}