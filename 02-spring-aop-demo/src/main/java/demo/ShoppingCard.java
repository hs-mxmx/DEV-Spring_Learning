package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCard {

    public void checkout(String status) {
        // Logging
        // Authentication & Authorization
        // Sanitize the Data
        // Business Logic
        // Cross Cutting Concerns (Aspects)
        System.out.println("Checkout message from Shopping Card " + status + ".");
    }

    public int quantity()  {
        return 5;
    }

}
