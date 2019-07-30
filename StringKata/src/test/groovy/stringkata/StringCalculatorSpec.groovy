package stringkata

import spock.lang.Specification

class StringCalculatorSpec extends Specification {
	
	def "Sum of Two Numbers"(){
		expect:
			StringCalculator.add("")	==	0
			StringCalculator.add("1")	==	1
			StringCalculator.add("1,2")	==	3
			StringCalculator.add("1,2,3,4")	==	10
			StringCalculator.add("1\n2,3")	==	6
			StringCalculator.add("//;\n1;2")	==	3
	}
	
	def "Sum of Two Numbers:Negative"(){
		given:"numbers is given"
			numbers;
		when:"add method is called"
			StringCalculator.add(numbers);
		then:"validate results"
			def error = thrown(RuntimeException);
			error.message == expectedMessage;
		where: 
			numbers			||	expectedMessage
			"-1,2"			|| "negatives not allowed:-1"
			"//;\n-1;2"		|| "negatives not allowed:-1"
	} 
}
