import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String username;
	private String password;
	private ArrayList<Book> bookList;
	
	public User(String username, String password, ArrayList<Book> bookList) {
		this.username = username;
		this.password = password;
		this.bookList = bookList;
	}
	
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof User)) {
			return false;
		}
		
		User u = (User)obj;
		return username.equals(u.username) && password.equals(u.password) &&bookList.equals(u.bookList);
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ArrayList<Book> getBookList() {
		return this.bookList;
	}
}

