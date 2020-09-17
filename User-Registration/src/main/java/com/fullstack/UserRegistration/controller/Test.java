package com.fullstack.UserRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class Test {

	private Test2 test2;
	
	
	Test(){
		System.out.println("This is Test class");
	}
	public void m2() {
		this.test2.m1();
		System.out.println("thsi is mq");
	}
	
}
