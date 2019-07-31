package paymentexample

import mockit.Mock
import mockit.MockUp
import spock.lang.Shared
import spock.lang.Specification

class PaymentServiceSpec extends Specification {
	
	@Shared def paymentService;
	@Shared def userValidator;
	@Shared def user;
	@Shared def paymentDetails;
	@Shared def paymentGatewayService;
	def setupSpec() {
		userValidator = Mock(UserValidator.class);
		paymentGatewayService = Mock(PaymentGatwayService.class);
		paymentService = new PaymentService(userValidator,paymentGatewayService);
		user = new User();
		paymentDetails = new PaymentDetails();
	}
	
	def "throw an exception for invalid User"(){
		given:
			userValidator.validate(user)>>true;
		when:
			paymentService.processPayment(user,paymentDetails);
		then:
			thrown(InvalidUserException)
	}
	
	def "process payment for valid user"(){
		given:
			def paymentDetails = new PaymentDetails();
			def user = new User();
			userValidator.validate(user)>>false;
		when:
			paymentService.processPayment(user,paymentDetails);
		then:
			1*paymentGatewayService.payment(paymentDetails);
	}
	
	
}
