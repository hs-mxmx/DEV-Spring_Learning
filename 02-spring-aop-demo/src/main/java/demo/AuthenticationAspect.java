package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
// Crossharing object
@Component
public class AuthenticationAspect {

    @Pointcut("within(demo..*)")
    // within -> Which particular type of class we want to execute
    // for all the methods available
    public void authenticatingPointCut() {
    }

    @Pointcut("within(demo..*)")
    public void authorizationPointCut() {
    }

    @Before("authenticatingPointCut() && authorizationPointCut()")
    // Authenticate before the methods are called on the pointcuts
    // Authentication before pointcuts
    public void authenticate() {
        System.out.println("[+] Authenticating the Request" );
    }
}
