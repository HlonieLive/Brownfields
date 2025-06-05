package co.testing;

import customer.order.info.OrderProcessor;
import customer.order.payment.PaymentMethod;
import customer.order.processor.PaymentProcessorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static co.testing.TestUtils.createInvalidEnumValue;
import static org.junit.jupiter.api.Assertions.*;

public class TestOrderProcessor {

    private OrderProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new OrderProcessor();
    }

    @Test
    public void testLoyalCustomerFinalCost() {
        double totalCost = 100.0;
        double tax = 10.0;
        double discount = 5.0;

        double finalCost = processor.calculateFinalCost(totalCost, tax, discount);
        assertEquals(105.0, finalCost);
    }

    @Test
    public void testNormalFinalCost() {
        double totalCost = 100.0;
        double tax = 10.0;
        double discount = 0.0;

        double finalCost = processor.calculateFinalCost(totalCost, tax, discount);
        assertEquals(110, finalCost);
    }

    @Test
    public void testCashPaymentMethod() {
        OrderProcessor orderProcessor = new OrderProcessor();

        // Test with a valid payment method (e.g., CASH)
        assertDoesNotThrow(() -> {
            orderProcessor.processOrder("John Doe", "Laptop and accessories", PaymentMethod.CASH);
        });
    }

    @Test
    public void testCreditPaymentMethod() {
        OrderProcessor orderProcessor = new OrderProcessor();
        // Test with another valid payment method (e.g., CREDIT)
        assertDoesNotThrow(() -> {
            orderProcessor.processOrder("Loyal Customer", "Smartphone and charger", PaymentMethod.CREDIT);
        });
    }

    @Test
    public void testNullPaymentMethod() {
        OrderProcessor orderProcessor = new OrderProcessor();

        // Test with a null payment method
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            orderProcessor.processOrder("John Doe", "Laptop and accessories", null);
        });

        // Verify the exception message
        assertEquals("Invalid Payment Method!", exception.getMessage());
    }

    @Test
    public void testInvalidPaymentMethodInDefaultCase() throws Exception {
        // Use reflection to create an invalid enum value (e.g., "PayPal")
        PaymentMethod invalidPaymentMethod = createInvalidEnumValue(PaymentMethod.class);

        // Pass the invalid payment method to the factory
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PaymentProcessorFactory.getPaymentMethod(invalidPaymentMethod);
        });

        // Verify the exception message
        assertEquals("Invalid Payment Method!", exception.getMessage());
    }
}
