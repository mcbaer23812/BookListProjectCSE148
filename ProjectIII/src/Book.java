import java.io.Serializable;

public class Book implements Serializable{
	private String isbn;
	private String author;
	private String title;
	private String price;
	private String path;
	
	public Book() {
		this("null","null", "null", "null", "null");
	}
	
	public Book(String ISBN, String author, String title, String price, String path) {
		this.isbn = new String(ISBN);
		this.author = new String(author);
		this.title = new String(title);
		this.price = new String(price);
		this.path = new String(path);
	}
	
	public void setISBN(String ISBN) {
		this.isbn = ISBN;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getISBN() {
		return this.isbn;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Book)) {
			return false;
		}
		
		Book b = (Book)obj;
		return isbn.equals(b.isbn) && author.equals(b.author) && title.equals(b.title) && price.equals(b.price);

	}
}

