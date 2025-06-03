OrderProcessor


```java
public class OrderProcessor {
    public void processOrder(String customerName, String orderDetails, String paymentMethod) {
        double totalCost = calculateTotalCost(orderDetails);
        double tax = calculateTax(totalCost);
        double discount = calculateDiscount(customerName, totalCost);
        double finalCost = totalCost + tax - discount;

        if (paymentMethod.equals("cash")) {
            System.out.println("Processing cash payment...");
            // Code to process cash payment
        } else if (paymentMethod.equals("credit")) {
            System.out.println("Processing credit payment...");
            // Code to process credit payment
        } else {
            System.out.println("Invalid payment method");
            return;
        }

        System.out.println("Order processed successfully!");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Details: " + orderDetails);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Tax: " + tax);
        System.out.println("Discount: " + discount);
        System.out.println("Final Cost: " + finalCost);
    }

    private double calculateTotalCost(String orderDetails) {
        // Complex logic to calculate total cost
        // For simplicity, let's assume it's just a hardcoded value
        return 100.0;
    }

    private double calculateTax(double totalCost) {
        // Complex logic to calculate tax
        // For simplicity, let's assume it's just 10% of total cost
        return totalCost * 0.1;
    }

    private double calculateDiscount(String customerName, double totalCost) {
        // Complex logic to calculate discount
        // For simplicity, let's assume it's just 5% of total cost for loyal customers
        if (customerName.startsWith("Loyal")) {
            return totalCost * 0.05;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder("John Doe", "Order details", "cash");
    }
}
```


*Refactoring Tasks:*

1. *Extract methods*: Break down the `processOrder` method into smaller, more manageable methods.
2. *Use enums*: Replace the string-based payment method with an enum.
3. *Use a payment processor interface*: Introduce an interface for payment processing to make the code more extensible.
4. *Improve code organization*: Organize the code into separate classes or packages to improve maintainability.
5. *Add unit tests*: Write unit tests to ensure the refactored code works as expected.

Your task is to refactor this legacy code to make it more maintainable, efficient, and scalable. Good luck!