package customer.order.processor;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing cash payment...");
    }
}
