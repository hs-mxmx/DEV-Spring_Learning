package demo_spring_components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");*/
        ApplicationContext context =  new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        Staff nurse = (Nurse) context.getBean("nurse");

        doctor.assist();
        nurse.assist();

        doctor.setQualification("MBBS");
        System.out.println(doctor);

        /*Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);*/
    }

}
