import javax.persistence.*;
@Entity
@javax.persistence.Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private int cid;

    @Column(name = "name")
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int getCid() {
        return cid;
    }
    // Bidirectional relationship with Driver
    @ManyToOne
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}