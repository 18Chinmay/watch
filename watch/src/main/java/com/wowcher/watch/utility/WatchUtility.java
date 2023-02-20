package com.wowcher.watch.utility;

import org.springframework.stereotype.Component;

@Component
public class WatchUtility {
	
	/**
	 * The purpose of this method is to utilize utility number into words
	 * @param number
	 * @return String having words
	 */
	public static String convertNumberToWords(int number) {
        String[] ones = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tens = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        if (number < 20) {
            return ones[number];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(tens[number / 10 - 2]);

        if (number % 10 != 0) {
            sb.append(" ");
            sb.append(ones[number % 10]);
        }

        return sb.toString();
    }
	
	

}
