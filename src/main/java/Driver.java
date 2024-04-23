import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private int did;

    @Column(name = "experience")
    private int experience;

    @Column(name = "name")
    private String name;

    // One driver may run many cars
    // Define the one-to-many relationship with Car
    @OneToMany(mappedBy = "driver")
    private List<Car> cars = new ArrayList<>();

    // Constructors, getters, and setters

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
