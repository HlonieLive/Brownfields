package customer.order;

import customer.order.info.OrderProcessor;
import customer.order.payment.PaymentMethod;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        System.out.println();
        // Process an order with cash payment
        orderProcessor.processOrder("John Doe", "Laptop and accessories", PaymentMethod.CASH);
        System.out.println();
        // Process an order with credit payment
        orderProcessor.processOrder("Loyal Customer", "Smartphone and charger", PaymentMethod.CREDIT);
        // Process an Invalid order
        orderProcessor.processOrder("John Doe", "TV", null);
    }
}