package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
// Crossharing object
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCard.*(..))")
    // execution -> Which particular method we want to execute
    public void beforeLogger(JoinPoint jp) {
        System.out.println("- Before Logger for " + jp.getSignature());
        /*for (Object element : jp.getArgs()) {
            System.out.println(element.getClass() + ": " + element.toString());
        };*/
    }

    // * -> Any return type
    // * -> Any package
    // * -> Any class
    // .. -> Whatever the number of params it will match
    @After("execution(* *.*.checkout(..))")
    public void afterLogger(JoinPoint jp){
        System.out.println("- After Logger for " + jp.getSignature());
    }

    // What is something we want to call and where we want to call
    // Acts like a breakpoint, specifying a checkpoint in a method in order to
    // proceed with before/after/afterReturning/etc. operations
    @Pointcut("execution(* *.*.quantity(..))")
    public void quantityPointCut(){}

    @AfterReturning(pointcut = "quantityPointCut()", returning = "retVal")
    public void afterReturning(Object retVal){
        System.out.println("- After Returning: " + retVal.toString());
    }

}
