package stack

import spock.lang.Shared
import spock.lang.Specification

class StackShould extends Specification{
	@Shared def stack;
	def setupSpec() {
		stack =new Stack();
	}
	def "throw exception if popped when stack is empty"(){
		given:
			stack =new Stack();
		when:
			stack.pop();
		then:
			thrown(EmptyStackException);
		
	}
	
	def "pop elements in reverse order they were pushed"(){
		expect:
			stack.push(1);
			stack.push(2);
			2==stack.pop()
			stack.push("StringObject");
			"StringObject"==stack.pop()
	}
}
