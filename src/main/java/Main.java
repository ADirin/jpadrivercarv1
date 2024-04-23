import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = org.example.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create a new Driver entity
            Driver driver = new Driver("Amir ", 10);

            // Save the driver entity
            session.save(driver);

            // Create a new Car entity
            Car car = new Car();
            car.setName("Honda");

            // Associate the car with the driver
            car.setDriver(driver);

            // Save the car entity
            session.save(car);

            // Commit the transaction
            transaction.commit();

            // Retrieve the driver entity (optional)
            Driver savedDriver = session.get(Driver.class, driver.getDid());
            System.out.println("Driver: " + savedDriver.getName());
            System.out.println("Associated Cars: " + savedDriver.getCars());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
