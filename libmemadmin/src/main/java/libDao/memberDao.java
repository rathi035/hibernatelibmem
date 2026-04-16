package libDao;

import entity.Member;

public interface memberDao {
	
	void addMember(Member m);
	boolean isMember(int id);

}
