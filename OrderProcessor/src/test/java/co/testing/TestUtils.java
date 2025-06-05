package co.testing;

import java.lang.reflect.Constructor;

public class TestUtils {
    public static <T extends Enum<?>> T createInvalidEnumValue(Class<T> enumClass) throws Exception {
        // Use reflection to access the private constructor of the enum
        Constructor<T> constructor = enumClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);

        // Create an invalid enum value (e.g., "PayPal")
        return constructor.newInstance("PayPal", -1);
    }
}