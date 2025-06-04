package customer.order.info;

import customer.order.payment.PaymentMethod;
import customer.order.processor.PaymentProcessor;
import customer.order.processor.PaymentProcessorFactory;

public class OrderProcessor {
    public void processOrder(String customerName, String orderDetails, PaymentMethod paymentMethod) {
        double totalCost = calculateTotalCost(orderDetails);
        double tax = calculateTax(totalCost);
        double discount = calculateDiscount(customerName, totalCost);
        double finalCost = calculateFinalCost(totalCost, tax, discount);

        PaymentProcessor paymentProcessor = PaymentProcessorFactory.getPaymentMethod(paymentMethod);
        paymentProcessor.process(finalCost);

        printOrderSummary(customerName, orderDetails, totalCost, tax, discount, finalCost);

    }

    private double calculateFinalCost(double totalCost, double tax, double discount) {
        return totalCost + tax - discount;
    }

    private void printOrderSummary(String customerName, String orderDetails, double totalCost, double tax, double discount, double finalCost) {
        System.out.println("Order processed successfully!");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Details: " + orderDetails);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Tax: " + tax);
        System.out.println("Discount: " + discount);
        System.out.println("Final Cost: " + finalCost);
    }

    private double calculateTotalCost(String orderDetails){
        return 100.0;
    }

    private double calculateTax(double totalCost) {
        return totalCost * 0.1;
    }

    private double calculateDiscount(String customerName, double totalCost) {
        if (customerName.startsWith("Loyal")) {
            return totalCost * 0.05;
        } else {
            return 0;
        }
    }
}
