package romannumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RomanNumeralConvertor {
	
	Map<Integer,String> numerals=new LinkedHashMap<>();
	
	RomanNumeralConvertor(){
		numerals.put(50, "L");
		numerals.put(10, "X");
		numerals.put(5, "V");
		numerals.put(1, "I");
	}
	
	public String convertToRomanNumerals(int number) {
		StringBuilder romanNumerals=new StringBuilder();
		Set<Integer> keys= numerals.keySet();
		for(Integer key:keys) {
			while(number>=key) {
				romanNumerals.append(numerals.get(key));
				number-=key;
			}
		}
		return romanNumerals.toString();
	}
}
