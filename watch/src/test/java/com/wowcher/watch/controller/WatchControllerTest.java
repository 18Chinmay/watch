package com.wowcher.watch.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wowcher.watch.service.WatchService;

public class WatchControllerTest {
	
	@InjectMocks
	WatchController watchController;
	
	@Mock
	WatchService watchService;
	
	 	
	@Test
	public void getSpeakingWatchTest() {
		MockitoAnnotations.initMocks(this);
		String time = "10:30";
		Mockito.when(watchService.getTimeInWords(time)).thenReturn("It's ten thirty am");
		ResponseEntity<Object> mesaage = watchController.getSpeakingWatch(time);
		assertEquals("It's ten thirty am", mesaage.getBody());
		assertEquals(HttpStatus.OK, mesaage.getStatusCode());
	}
	
	@Test
	public void getSpeakingWatchEmptyTest() {
		MockitoAnnotations.initMocks(this);
		String time = "";
		Mockito.when(watchService.getTimeInWords(time)).thenReturn("");
		ResponseEntity<Object> mesaage = watchController.getSpeakingWatch(time);
		assertEquals(HttpStatus.BAD_REQUEST, mesaage.getStatusCode());
		assertEquals("Invalid Input, Please enter time in HH:MM format", mesaage.getBody());
	}
	
	@Test
	public void getSpeakingWatchSpecialCharacterTest() {
		MockitoAnnotations.initMocks(this);
		String time = "#%^%**";
		Mockito.when(watchService.getTimeInWords(time)).thenReturn("");
		ResponseEntity<Object> mesaage = watchController.getSpeakingWatch(time);
		assertEquals(HttpStatus.BAD_REQUEST, mesaage.getStatusCode());
		assertEquals("Invalid Input, Please enter time in HH:MM format", mesaage.getBody());
	}
	
	@Test
	public void getSpeakingWatchCharacterOnlyTest() {
		MockitoAnnotations.initMocks(this);
		String time = "asdfh";
		Mockito.when(watchService.getTimeInWords(time)).thenReturn("");
		ResponseEntity<Object> mesaage = watchController.getSpeakingWatch(time);
		assertEquals(HttpStatus.BAD_REQUEST, mesaage.getStatusCode());
		assertEquals("Invalid Input, Please enter time in HH:MM format", mesaage.getBody());
	}
	
	@Test
	public void getSpeaking12NoonTest() {
		MockitoAnnotations.initMocks(this);
		String time = "12:30";
		Mockito.when(watchService.getTimeInWords(time)).thenReturn("It's Mid Night");
		ResponseEntity<Object> mesaage = watchController.getSpeakingWatch(time);
		assertEquals("It's Mid Night", mesaage.getBody());
		assertEquals(HttpStatus.OK, mesaage.getStatusCode());
	}
	
	@Test
	public void getSpeaking12MidDayTest() {
		MockitoAnnotations.initMocks(this);
		String time = "12:00";
		Mockito.when(watchService.getTimeInWords(time)).thenReturn("It's Mid day");
		ResponseEntity<Object> mesaage = watchController.getSpeakingWatch(time);
		assertEquals("It's Mid day", mesaage.getBody());
		assertEquals(HttpStatus.OK, mesaage.getStatusCode());
	}
}
