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

            // Create a new Car entity
            Car car = new Car();
            car.setName("Honda");


            Driver driver = new Driver("Timo ", 5);
            //2. we need to add the car object as we added in driver class
            driver.setCar(car);




            // Save the car entity
            session.save(car);
            session.save(driver);

            transaction.commit();
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
