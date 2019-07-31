package romannumber

import spock.lang.Shared
import spock.lang.Specification

class RomanNumeralConvertorSpec extends Specification {
	
	@Shared def convertor;
	
	def setupSpec() {
		convertor = new RomanNumeralConvertor();
	}
	
	def "should convert to roman numerals"(){
		expect:
		 convertor.convertToRomanNumerals(1)=="I";
		 convertor.convertToRomanNumerals(3)=="III";
		 convertor.convertToRomanNumerals(5)=="V";
		 convertor.convertToRomanNumerals(8)=="VIII";
		 convertor.convertToRomanNumerals(10)=="X";
		 convertor.convertToRomanNumerals(11)=="XI";
		 convertor.convertToRomanNumerals(15)=="XV";
		 convertor.convertToRomanNumerals(18)=="XVIII";
		 convertor.convertToRomanNumerals(20)=="XX";
		 convertor.convertToRomanNumerals(22)=="XXII";
		 convertor.convertToRomanNumerals(27)=="XXVII";
		 convertor.convertToRomanNumerals(33)=="XXXIII";
		 convertor.convertToRomanNumerals(50)=="L";
	}
}
