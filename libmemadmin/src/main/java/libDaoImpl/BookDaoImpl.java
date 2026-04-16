package libDaoImpl;
import libDao.BookDao;
import entity.Book;
import util.HibernateUtil;
import org.hibernate.*;
import java.util.List;

public class BookDaoImpl implements BookDao{
	
	 public void addBook(Book b) {
	        Session s = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = s.beginTransaction();
	        s.save(b);
	        tx.commit();
	        s.close();
	    }

	    public void removeBook(int id) {
	        Session s = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = s.beginTransaction();

	        Book b = s.get(Book.class, id);
	        if (b != null) s.delete(b);

	        tx.commit();
	        s.close();
	    }

	    public void updateBook(Book b) {
	        Session s = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = s.beginTransaction();
	        s.update(b);
	        tx.commit();
	        s.close();
	    }
	    
        public Book getBook(int id) {
        	Session s = HibernateUtil.getSessionFactory().openSession();
            Book b = s.get(Book.class,id);
            s.close();
            return b;
        }
        
        public List<Book> getAllBooks() {
            Session s = HibernateUtil.getSessionFactory().openSession();
            List<Book> list = s.createQuery("from Book", Book.class).list();
            s.close();
            return list;
        }
        public void issueBook(int id) {
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();

            Book b = s.get(Book.class, id);
            if (b != null && b.getStatus().equals("Available")) {
                b.setStatus("Issued");
                s.update(b);
            }
            tx.commit();
            s.close();
        }
        public void returnBook(int id) {
        	Session s = HibernateUtil.getSessionFactory().openSession();
        	Transaction tx = s.beginTransaction();
        	
        	Book b = s.get(Book.class,id);
        	if(b != null) {
        		b.setStatus("Available");
        		s.update(b);
        	}
        	tx.commit();
        	s.close();
        }

}
