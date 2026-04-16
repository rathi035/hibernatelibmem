package util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Book;
import entity.Member;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Member.class).buildSessionFactory();
		
	}
	public static SessionFactory getSessionFactory() {
		 return factory;
	}
	

}
