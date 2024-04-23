import javax.persistence.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Entity
@javax.persistence.Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private int did;
    @Column(name = "experience")
    private int experience;
    @Column(name = "name")
    private String name;
    // 2. There should be link between the driver and car
    //2.1 we need to add the relationship between car and driver
    //2.2 we design as one to oen
    //2.3 specify the join id
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name="car_id")
    private Car car;
    //add setter and getter for Car



    public Driver() {
    }

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;

    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}