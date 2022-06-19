package demo_spring_components;

import demo_spring_components.Staff;
import org.springframework.stereotype.Component;

public class Nurse implements Staff {
    public void assist() {
        System.out.println("Nurse is assisting");
    }

}