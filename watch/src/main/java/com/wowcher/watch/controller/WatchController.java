package com.wowcher.watch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.wowcher.watch.service.WatchService;

@RestController
public class WatchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WatchController.class);
	
	@Autowired
	WatchService watchService;
	
	@GetMapping("/{time}")
	public ResponseEntity<Object> getSpeakingWatch(@PathVariable String time){
		
		LOGGER.info("get time from user {}", time);
		
		String timeInWords = watchService.getTimeInWords(time);
		
		if(null == timeInWords || timeInWords.isBlank()) {
			return new ResponseEntity<Object> ("Invalid Input, Please enter time in HH:MM format", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object> (timeInWords, HttpStatus.OK);
	}

}
