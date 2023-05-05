import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Data {
	
	private static Data instance = null;
	private ArrayList<User> userList;
	
	private Data() {
		userList = new ArrayList<>();
	}
	
	public static Data getInstance() {
		
		if(instance == null) {
			instance = new Data();
		}
		return instance;
	}
	
	public boolean findUser(String username, String password) {
		boolean found = false;
		for(User user: userList) {
			
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public User returnUserObject(String username, String password) {
		for(User user: userList) {
			
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				User u = new User(user.getUsername(),user.getPassword(),user.getBookList());
				return u;
			}
		}
		return null;
	}
	
	public boolean saveUserData(User u) {
		addUser(u);
		String fileName = "userData.dat";
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(userList);
			return true;
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadUserData(String username, String password) {
		String fileName = "userData.dat";
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			userList = (ArrayList<User>)ois.readObject();
			if(!(findUser(username,password))) {
				return false;
			}
		} catch(IOException | ClassNotFoundException ie) {
			ie.printStackTrace();
		}
		return true;
	}
	
	public boolean addUser(User u) {
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).equals(u)) {
				return false;
			}
		}
		userList.add(u);
		return true;
	}
	
	
	public boolean addBook(User u, Book b) {
		String fileName = "userData.dat"; 
		u.getBookList().add(b);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(new ArrayList<User>(userList));
			return true;
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteBook(User u, Book b) {
		String fileName = "userData.dat";
		u.getBookList().remove(b);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(new ArrayList<User>(userList));
			return true;
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		return false;
	}
}
