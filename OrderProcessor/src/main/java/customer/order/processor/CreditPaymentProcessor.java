package customer.order.processor;

public class CreditPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing credit payment...");
    }
}
