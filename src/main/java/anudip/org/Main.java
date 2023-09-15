package anudip.org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
        
        SessionFactory factory=md.getSessionFactoryBuilder().build();  
        
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        
        Customers c=new Customers();
        c.setCname("Amar");
        
        Customers c1=new Customers();
        c1.setCname("Heena");
        
        Orders or=new Orders();
        or.setCost(1200);
        Orders or1=new Orders();
        or1.setCost(8000);
        
        c.getOrders().add(or);
        c.getOrders().add(or1);
        c1.getOrders().add(or);
        
        session.save(c);
        session.save(c1);
        session.save(or);
        session.save(or1);
        t.commit();
        
        factory.close();
        session.close();

	}

}
