package com.wowcher.watch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class WatchServiceTest {
	
	@InjectMocks
	WatchService watchService;
	
	@Test
	public void getTimeInWordsTest() {
		MockitoAnnotations.initMocks(this);
		String message = watchService.getTimeInWords("10:30");
		assertEquals("It's ten thirty a.m.", message);
	}
	
	@Test
	public void getTimeInfor12NoonTest() {
		MockitoAnnotations.initMocks(this);
		String message = watchService.getTimeInWords("12:00");
		assertEquals("It's Midday", message);
	}
	
	@Test
	public void getTimeInfor12MidNightTest() {
		MockitoAnnotations.initMocks(this);
		String message = watchService.getTimeInWords("24:00");
		assertEquals("It's Midnight", message);
	}
	
	@Test
	public void getTimeInforEmptyTest() {
		MockitoAnnotations.initMocks(this);
		String message = watchService.getTimeInWords("");
		assertEquals("Invalid Input, Please enter time in HH:MM format", message);
	}
	
	@Test
	public void getTimeInforSpecialCharTest() {
		MockitoAnnotations.initMocks(this);
		String message = watchService.getTimeInWords("!@#$%^&*");
		assertEquals("Invalid Input, Please enter time in HH:MM format", message);
	}
	
	@Test
	public void getTimeContainingOnlyCharTest() {
		MockitoAnnotations.initMocks(this);
		String message = watchService.getTimeInWords("asdfgjhjkl");
		assertEquals("Invalid Input, Please enter time in HH:MM format", message);
	}

}
