package com.test.genericity;

import com.test.genericity.domain.LogOne;
import com.test.genericity.domain.Person;

public class DoFunction extends BaseFunction<Person, LogOne>{

	public void testGenericity(){
		Person person = new Person("zhangsan","24");
		LogOne one = new LogOne();
		one.setId(3l);
		one.setEqumentNo("abc123");
		Person obj = this.getObjcet(person, "speak", one);
	}
	
	public static void main(String[] args) {
		DoFunction fun = new DoFunction();
		fun.testGenericity();
	}
}
