import spock.lang.Specification

class SampleSpec extends Specification {
	def "testing positive result"(){
		expect: true==true
	}
	
	def "testing negative result"(){
		expect: false==true
	}
}
