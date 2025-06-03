package customer.order.processor;

import customer.order.payment.PaymentMethod;

public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentMethod(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case CASH:
                return new CashPaymentProcessor();

            case CREDIT:
                return new CreditPaymentProcessor();

            default:
                throw new IllegalArgumentException("Invalid Payment Method!");
        }
    }
}
