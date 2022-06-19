package demo;

public class Nurse implements Staff{

    private String qualification;
    private String destination;

    public Nurse(String qualification){
        this.qualification = qualification;
    }

    public void assist(){
        System.out.println("Nurse is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDestination() {return destination;}

    public void setDestination(String destination) {this.destination = destination;}

}
