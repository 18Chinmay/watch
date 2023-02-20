package com.wowcher.watch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wowcher.watch.utility.WatchUtility;

@Service
public class WatchService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WatchService.class);
	
	/**
	 * The purpose of this method is to convert date into words
	 * @param date
	 * @return String with words
	 */
	public String getTimeInWords(String date) {
		
		String result = "";
		
		if(date.isBlank() || date.length()<3 || !date.contains(":")) {
			
			LOGGER.error("invalid input {}", date);
			
		 return "Invalid Input, Please enter time in HH:MM format"; 
			
		}
		try {
		
		 if (date.equals("12:00") || date.equals("12:00 am") || date.equals("12:00am")) {
	            return "It's Midday";
	        }

	     if (date.equals("24:00") || date.equals("12:00pm") || date.equals("12:00 pm")) {
	            return "It's Midnight";
	        }
		
		if(date.contains(":") && date.length()>=5 && !date.startsWith("12:00")) {
			
			String[] timeParts = date.split(":");
	        int hour = Integer.parseInt(timeParts[0]);
	        int minute = Integer.parseInt(timeParts[1]);

	        String hourString = WatchUtility.convertNumberToWords(hour % 12 == 0 ? 12 : hour % 12);
	        String minuteString = WatchUtility.convertNumberToWords(minute);

	        String ampm = hour < 12 ? "a.m." : "p.m.";

	        result = "It's " + hourString + " " + minuteString + " " + ampm;
	        
	        LOGGER.info("After completion number into words {}", result);
	        
	        
		}}catch (Exception e) {
			LOGGER.error("invalid input {} from user", date);
			return result;
		}
		
		return result;
		
	}

}
