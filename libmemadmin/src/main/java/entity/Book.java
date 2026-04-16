package entity;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	private int bookId;
	
	private String bookName;
	private String authorName;
	private double price;
	private String status;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
	      return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
