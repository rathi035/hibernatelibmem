package libDaoImpl;
import libDao.memberDao;
import entity.Member;
import util.HibernateUtil;
import org.hibernate.*;

public class MemberDaoImpl implements memberDao {
	
	 public void addMember(Member m) {
	        Session s = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = s.beginTransaction();
	        s.save(m);
	        tx.commit();
	        s.close();
	    }
	 
	 public boolean isMember(int id) {
	        Session s = HibernateUtil.getSessionFactory().openSession();
	        Member m = s.get(Member.class, id);
	        s.close();
	        return m != null;
	    }
	 

}
