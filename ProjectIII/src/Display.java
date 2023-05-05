import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/* Name: Mark Cappuccio-Baer
 * Date: 5/14/2022
 * Course:CSE148
 * Description: This program completes all functions except for the statistics functions listed in project III,
 * as I was unable to fully figure out how to implement those functions. The user is prompted with a screen in order to login
 * or sign up. After signing in, the user can access their book list and add, remove, or see their books listed in a table. They can search
 * for specific books through a search bar. All user data including books are saved to a binary data file. 
 * Attached to the blackboard page is a document explaining each function briefly.
 * 
 */
public class Display extends Application {
	
	private Book b;
	private TextField titleTF = new TextField();
	private TextField authorTF = new TextField();
	private TextField priceTF = new TextField();
	private TextField isbnTF = new TextField();
	private TextField pathTF = new TextField();	
	ObservableList<Book> bookData = FXCollections.observableArrayList();
	@Override
	public void start(Stage stage) throws Exception {
		
		//TabPane root = bookTabs();
		Pane root = loginOrSignup();
		Scene scene = new Scene(root,300,200);
		stage.setScene(scene);
		stage.setTitle("BookList Login");
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	//incomplete statistics function
	/*public TabPane statsInfo(Book b) {
		String s[][] = Data.getInstance().uniqueWords(b);
		PieChart pc = new PieChart();
		TableView<String> tv = new TableView<>();
		TabPane tPane = new TabPane();
		Tab pie = new Tab("Pie Chart",pc);
		Tab table = new Tab("Book Editor",tv);		
		tPane.getTabs().addAll(pie,table);
		return tPane;
		
	}*/

	public Pane bookEditor(User u) {
		
		BorderPane bPane = new BorderPane();
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(10));
		GridPane gPane = new GridPane();
		gPane.setPadding(new Insets(10));
		gPane.setAlignment(Pos.CENTER);
		gPane.setVgap(10);
		gPane.setHgap(15);
		
		Label titleLB = new Label("Title:");
		Label authorLB = new Label("Author:");
		Label priceLB = new Label("Price:");
		Label isbnLB = new Label("ISBN:");
		Label pathLB = new Label("File Path:");
		titleTF = new TextField();
		authorTF = new TextField();
		priceTF = new TextField();
		isbnTF = new TextField();
		pathTF = new TextField();	
		
		Button btnAdd = new Button("Add");
		btnAdd.setOnAction(e->{
			if(titleTF.getText().equals(null) || titleTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Title field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(authorTF.getText().equals(null) || authorTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Author field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(priceTF.getText().equals(null) || priceTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Price field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(isbnTF.getText().equals(null) || isbnTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("ISBN field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(pathTF.getText().equals(null) || pathTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Path field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else {
				Book b = new Book(isbnTF.getText(),authorTF.getText(),titleTF.getText(),priceTF.getText(),pathTF.getText());
				Data.getInstance().addBook(u, b);
				Data.getInstance().saveUserData(u);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Book has been added to the list");
				alert.setContentText("Book Addition Succeeded");
				alert.showAndWait();
			}
		});
		
		Button btnRemove = new Button("Remove");
		btnRemove.setOnAction(e->{
			Book b = new Book(isbnTF.getText(),authorTF.getText(),titleTF.getText(),priceTF.getText(),pathTF.getText());
			if(titleTF.getText().equals(null) || titleTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Title field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(authorTF.getText().equals(null) || authorTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Author field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(priceTF.getText().equals(null) || priceTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Price field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(isbnTF.getText().equals(null) || isbnTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("ISBN field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(pathTF.getText().equals(null) || pathTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Path field is empty");
				alert.setContentText("Book Addition Failed");
				alert.showAndWait();
			} else if(!(bookData.contains(b))) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Book not found");
				alert.setContentText("Book does not exist");
				alert.showAndWait();
			} else {
				Data.getInstance().deleteBook(u, b);
				Data.getInstance().saveUserData(u);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Book has been removed from the list");
				alert.setContentText("Book Removal Succeeded");
				alert.showAndWait();
			}
		});
		Button btnChooseFile = new Button("Choose File");
		btnChooseFile.setOnAction(e->{
			Stage stage = new Stage();
			FileChooser fc = new FileChooser();
			fc.setTitle("Upload Text File Path");
			fc.setInitialDirectory(new File("BookTextFileStorage"));
			fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
			File sf = fc.showOpenDialog(stage);
			if(sf  == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("No file was chosen");
				alert.setHeaderText("File path not filled");
				alert.showAndWait();
			} else {
				pathTF.setText(sf.getPath());
			}
		});
		hBox.getChildren().addAll(btnAdd,btnRemove,btnChooseFile);	
		bPane.setTop(hBox);
		bPane.setCenter(gPane);
		
		
		gPane.add(titleLB, 0, 0, 1, 1);
		gPane.add(authorLB,0, 1, 1, 1);
		gPane.add(priceLB, 0, 2, 1, 1);
		gPane.add(isbnLB, 0, 3, 1, 1);
		gPane.add(pathLB, 0, 4, 1, 1);
		gPane.add(titleTF, 1, 0, 1,1);
		gPane.add(authorTF, 1, 1, 1, 1);
		gPane.add(priceTF, 1, 2, 1, 1);
		gPane.add(isbnTF, 1, 3, 1, 1);
		gPane.add(pathTF, 1, 4, 1, 1);
		
		return bPane;
	}
	
	@SuppressWarnings("unchecked")
	public Pane bookTable(User u) {
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));
		bookData.addAll(u.getBookList());
		
		Button btnCopy = new Button("Copy");
		Button btnRefresh = new Button("Refresh");
		//Button btnStatistics = new Button("Statistics");
		Label lbTitle = new Label(u.getUsername() + "'s Book List");
		BorderPane.setAlignment(lbTitle, Pos.CENTER);
		BorderPane.setMargin(lbTitle, new Insets(5,0,5,0));
		TextField searchTF = new TextField();
		VBox vBox =  new VBox();
		vBox.getChildren().addAll(lbTitle,searchTF);
		HBox hBox = new HBox();
		hBox.getChildren().addAll(vBox, btnRefresh,btnCopy);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		pane.setTop(hBox);
		
		TableView<Book> tv = new TableView<>();
		
		TableColumn<Book, String> c0 = new TableColumn<>("Title");
		c0.setCellValueFactory(new PropertyValueFactory<>("title"));
		TableColumn<Book, String> c1 = new TableColumn<>("Author");
		c1.setCellValueFactory(new PropertyValueFactory<>("author"));
		TableColumn<Book, String> c2 = new TableColumn<>("Price");
		c2.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn<Book, String> c3 = new TableColumn<>("ISBN");
		c3.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		TableColumn<Book, String> c4 = new TableColumn<>("Path");
		c4.setCellValueFactory(new PropertyValueFactory<>("path"));
		
		tv.getColumns().addAll(c0,c1,c2,c3,c4);
		tv.setItems(bookData);
		pane.setCenter(tv);
		
		searchTF.setOnKeyTyped(e->{
			tv.getItems().clear();
			String s = searchTF.getText().toLowerCase();
			ArrayList<Book> b = new ArrayList<Book>();
			for(int i = 0; i < u.getBookList().size(); i++) {
				if(u.getBookList().get(i).getTitle().toLowerCase().contains(s)) {
					b.add(u.getBookList().get(i));
				} else if(u.getBookList().get(i).getAuthor().toLowerCase().contains(s)) {
					b.add(u.getBookList().get(i));
				}  else if(u.getBookList().get(i).getPrice().toLowerCase().contains(s)) {
					b.add(u.getBookList().get(i));
				}  else if(u.getBookList().get(i).getISBN().toLowerCase().contains(s)) {
					b.add(u.getBookList().get(i));
				} else if(u.getBookList().get(i).getPath().toLowerCase().contains(s)) {
					b.add(u.getBookList().get(i));
				}
			}
			bookData.addAll(b);
			tv.setItems(bookData);
			
		});
		
		btnRefresh.setOnAction(e->{
			tv.getItems().clear();
			bookTable(u);
			
		});
		
		btnCopy.setOnAction(e->{
			this.b = tv.getSelectionModel().getSelectedItem();
			if(this.b == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("No book was selected");
				alert.setHeaderText("Book not copied");
				alert.showAndWait();
			} else {
				this.titleTF.setText(this.b.getTitle());
				this.authorTF.setText(this.b.getAuthor());
				this.priceTF.setText(this.b.getPrice());
				this.isbnTF.setText(this.b.getISBN());
				this.pathTF.setText(this.b.getPath()); 
			}
		});
		
		return pane;
	}
	
	public TabPane bookTabs(User u) {
		
		TabPane tPane = new TabPane();
		Tab bookListTab = new Tab("Book Table",bookTable(u));
		Tab bookEditorTab = new Tab("Book Editor",bookEditor(u));		
		tPane.getTabs().addAll(bookListTab,bookEditorTab);
		return tPane;
	}
	
	public Pane loginScreen() {
		
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.setPadding(new Insets(10));
		gPane.setVgap(10);
		gPane.setHgap(15);
		
		TextField loginTF = new TextField();
		TextField passTF = new TextField();
		Label loginLB = new Label("Username:");
		Label passLB = new Label("Password:");
		Button loginBtn = new Button("Login");
		loginBtn.setPrefSize(75, 35);
		
		loginBtn.setOnAction(e->{
			String username = loginTF.getText();
			String password = passTF.getText();
			
			if(Data.getInstance().loadUserData(username,password)) {
				Data.getInstance().findUser(username,password);
				User u = Data.getInstance().returnUserObject(username, password);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Login Successful");
				alert.setContentText("User Login");
				alert.showAndWait();
				Stage stage = (Stage)loginBtn.getScene().getWindow();
				stage.close();
				TabPane root = bookTabs(u);
				Scene scene = new Scene(root,300,200);
				Stage stage2 = new Stage();
				stage2.setScene(scene);
				stage2.setTitle("Personal Library");
				stage2.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("User not found");
				alert.setHeaderText("Login Failed");
				alert.showAndWait();
			}
		});
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e->{
			Pane root = loginOrSignup();
			Scene scene = new Scene(root,300,200);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("User Login");
			stage.show();
			Stage stage2 = (Stage)cancelBtn.getScene().getWindow();
			stage2.close();
		});
		cancelBtn.setPrefSize(75, 35);
		
		gPane.add(loginLB, 0, 0,2,1);
		gPane.add(passLB, 0, 1,1,1);
		gPane.add(loginTF, 1, 0,2,1);
		gPane.add(passTF, 1, 1,2,1);
		gPane.add(loginBtn, 1, 2,1,1);
		gPane.add(cancelBtn,2,2,1,1);
		
		return gPane;
	}
	
	public Pane signupScreen() {
		
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.setPadding(new Insets(10));
		gPane.setVgap(10);
		gPane.setHgap(15);
		
		TextField userTF = new TextField();
		TextField passTF = new TextField();
		TextField confirmTF = new TextField();
		Label signupLB = new Label("Username:");
		Label passLB = new Label("Password:");
		Label confirmPassLB = new Label("Confirm Password:");
		
		Button signupBtn = new Button("Sign up");
		signupBtn.setPrefSize(75, 35);
		signupBtn.setOnAction(e->{
			String username = userTF.getText();
			String password = passTF.getText();
			if(!(passTF.getText().equals(confirmTF.getText()))){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Passwords do not match");
				alert.setHeaderText("Sign up Failed");
				alert.showAndWait();
			} else if(userTF.getText().equals(null) || userTF.getText().equals("") || passTF.getText().equals(null) || passTF.getText().equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Username or password field empty");
				alert.setHeaderText("Sign up Failed");
				alert.showAndWait();
			} else if(Data.getInstance().findUser(username, password)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("User already exists");
				alert.setHeaderText("Sign up Failed");
				alert.showAndWait();
			} else {
				ArrayList<Book> bookList = new ArrayList<>();
				User u = new User(username,password,bookList);
				Data.getInstance().saveUserData(u);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Successful");
				alert.setHeaderText("Sign up Successful");
				alert.showAndWait();
				Pane root = loginOrSignup();
				Scene scene = new Scene(root,300,200);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("BookList Login");
				stage.show();
				Stage stage2 = (Stage)signupBtn.getScene().getWindow();
				stage2.close();
			}
		});
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e->{
			Pane root = loginOrSignup();
			Scene scene = new Scene(root,300,200);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("User Login");
			stage.show();
			Stage stage2 = (Stage)cancelBtn.getScene().getWindow();
			stage2.close();
		});
		cancelBtn.setPrefSize(75, 35);
		
		gPane.add(signupLB, 0, 0, 2, 1);
		gPane.add(passLB, 0, 1, 1, 1);
		gPane.add(confirmPassLB, 0, 2, 1, 1);
		gPane.add(userTF, 1, 0, 2, 1);
		gPane.add(passTF, 1, 1, 2, 1);
		gPane.add(confirmTF, 1, 2, 2, 1);
		gPane.add(signupBtn, 1, 3, 1, 1);
		gPane.add(cancelBtn, 2, 3, 1, 1);
		
		return gPane;
		
		
	}
	
	public Pane loginOrSignup() {
		
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.setPadding(new Insets(10));
		gPane.setHgap(15);
		gPane.setVgap(10);
		Label questionLB = new Label("Login or sign up?");
		Button loginBtn = new Button("Login");
		loginBtn.setOnAction(e->{
			Pane root = loginScreen();
			Scene scene = new Scene(root,300,200);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("User Login");
			stage.show();
			Stage stage2 = (Stage)loginBtn.getScene().getWindow();
			stage2.close();
		});
		Button signupBtn = new Button("Sign up");
		signupBtn.setOnAction(e->{
			Pane root = signupScreen();
			Scene scene = new Scene(root,300,200);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("User Sign up");
			stage.show();
			Stage stage2 = (Stage)loginBtn.getScene().getWindow();
			stage2.close();
		});
		
		
		gPane.add(questionLB, 0, 0,2,1);
		gPane.add(loginBtn, 0, 1,1,1);
		gPane.add(signupBtn, 1, 1,1,1);
		
		return gPane;
		
		}

}