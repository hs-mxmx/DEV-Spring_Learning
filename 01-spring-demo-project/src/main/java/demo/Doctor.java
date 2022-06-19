package demo;

public class Doctor implements Staff {

    private String qualification;
    private Computer computer;
    private String destination;

    public Doctor(String qualification, Computer computer) {
        this.qualification = qualification;
        this.computer = computer;
    }

    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Computer getComputer() {return computer;}

    public void setComputer(Computer computer) {this.computer = computer;}

    public String getDestination() {return destination;}

    public void setDestination(String destination) {this.destination = destination;}
}
