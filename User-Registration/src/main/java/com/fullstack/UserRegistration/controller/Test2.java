package com.fullstack.UserRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class Test2 {

	
	
	private Test test;
	
	Test2(){
		test.m2();
		System.out.println("This is Test2 class");
	}
	public void m1() {
		this.test.m2();
		System.out.println("thsi is mq");
	}
}
