package com.spring.test;



import org.springframework.context.ConfigurableApplicationContext;

import com.spring.service.AService;
import com.spring.service.BServiceImpl;



public class AOPTest extends  {
	
	private AService aService;
	
	private BServiceImpl bService;
	
	protected String[] getConfigLocations() {
		String[] configs = new String[] { "/applicationContext.xml"};
		return configs;
	}
	
	
	/**
	 * 测试正常调用
	 */
	public void testCall()
	{
		System.out.println("SpringTest JUnit test");
		aService.fooA("JUnit test fooA");
		aService.barA();
		bService.fooB();
		bService.barB("JUnit test barB",0);
	}
	
	/**
	 * 测试After-Throwing
	 */
	public void testThrow()
	{
		try {
			bService.barB("JUnit call barB",1);
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	public void setAService(AService service) {
		aService = service;
	}
	
	public void setBService(BServiceImpl service) {
		bService = service;
	}


	@Override
	protected ConfigurableApplicationContext loadContext(Object arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}