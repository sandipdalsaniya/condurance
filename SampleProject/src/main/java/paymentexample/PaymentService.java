package paymentexample;

public class PaymentService {
	UserValidator userValidator;
	PaymentGatwayService paymentGatwayService;
	
	PaymentService(UserValidator userValidator,PaymentGatwayService paymentGatwayService){
		this.userValidator=userValidator;
		this.paymentGatwayService=paymentGatwayService;
	}
	
	public void processPayment(User user,PaymentDetails paymentDetails) {
		if(!userValidator.validate(user)) {
			throw new InvalidUserException();
		}
		paymentGatwayService.payment(paymentDetails);
	}
}
