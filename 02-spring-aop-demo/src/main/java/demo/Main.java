package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* AOP Project Example
Business logic taken apart from logging, authentication Sanitization...
Business logic in different place / separately from crossharing concerns
 */


public class Main {

    public static void main(String[] args) {

        // Context based in BeanConfig application instead of XML file configuration
        // Analyze and find the components in the package specified instead of configure it
        // manually in the XML file.
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCard card = context.getBean(ShoppingCard.class);
        card.checkout("unavailable");
        System.out.println(card.quantity());

    }

}
