package com.test.genericity.domain;

public class Person {

	private String name;
	private String age;
	
	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	public void speak(LogOne one){
		
		System.err.println(one.getId());
		System.err.println(one.getEqumentNo());
	}
	
	
	private LogTwo createTwo(String accountName){
		LogTwo two = new LogTwo();
		two.setAccountName(accountName);
		System.err.println("生产了logtwo");
		return two;
	}
}
