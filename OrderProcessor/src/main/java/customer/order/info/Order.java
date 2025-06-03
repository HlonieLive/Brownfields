package customer.order.info;

import customer.order.payment.PaymentMethod;

public class Order {
    private final String customerName;
    private final String orderNumber;
    private final PaymentMethod paymentMethod;

    public Order(String customerName, String orderNumber, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getOrderNumber(){
        return orderNumber;
    }
}
