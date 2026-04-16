package libDao;
import entity.Book;
import java.util.List;

public interface BookDao {
	void addBook(Book b);
	void removeBook(int id);
	void updateBook(Book b);
	Book getBook(int id);
	List<Book> getAllBooks();
	
	void issueBook(int id);
	void returnBook(int id);

}
