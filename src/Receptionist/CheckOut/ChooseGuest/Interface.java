
package Receptionist.CheckOut.ChooseGuest;

import static Receptionist.CheckIn.RoomInfo.Interface.account;
import static Receptionist.CheckIn.RoomInfo.Interface.menu;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface{
    
    Stage primaryStage;
    
    Image searchIcon;
    ImageView searchIconView;
    TableView table;
    
    ImageView accountView;
    ImageView menuView;
    
    TextField searchTxt;
    Button checkOut;
    
    TableColumn id;
    TableColumn firstName;
    TableColumn middleName;
    TableColumn lastName;
    TableColumn idcard;
    TableColumn email;
    TableColumn numOfDays;
    TableColumn gender;
    TableColumn status;
    TableColumn address;
    TableColumn roomid;
    TableColumn phone;
    TableColumn arriveDate;
    TableColumn checkoutdate;
    TableColumn foodid;
    TableColumn carid;
    TableColumn privatedriver;

    public Interface() {
        
        primaryStage = new Stage();
        searchIcon = new Image("/images/search.png");
        searchIconView = new ImageView(searchIcon);
        table = new TableView();
        
        searchTxt = new TextField();
        checkOut = new Button("CheckOut");
        
        accountView = new ImageView(account);
        menuView = new ImageView(menu);
        
        id = new TableColumn("Guest ID");
        firstName = new TableColumn("First Name");
        middleName = new TableColumn("Middle Name");
        lastName = new TableColumn("Last Name");
        idcard = new TableColumn("ID");
        email = new TableColumn("E-Mail");
        numOfDays = new TableColumn("Num Of Days");
        gender = new TableColumn("Gender");
        status = new TableColumn("Status");
        address = new TableColumn("Address");
        roomid = new TableColumn("Room ID");
        phone = new TableColumn("Phone");
        arriveDate = new TableColumn("Arrive Date");
        checkoutdate = new TableColumn("CheckOut Date");
        foodid = new TableColumn("Food ID");
        carid = new TableColumn("Car ID");
        privatedriver = new TableColumn("Private Driver");
    }

    public void start() {

        BorderPane page = new BorderPane();
        VBox sideMenu = new VBox(50);
        VBox search = new VBox(30);
        HBox searchBar = new HBox();
        HBox searchBtn = new HBox(50);
        
        ImageView logoView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        
        ImageView accountView = new ImageView(account);
        ImageView menuView = new ImageView(menu);
        
        sideMenu.getChildren().addAll(accountView, menuView);
        sideMenu.setPadding(new Insets(300, 100, 0, 20));
        
        Label searchIconLbl = new Label("",searchIconView);
        searchIconLbl.setContentDisplay(ContentDisplay.CENTER);
        searchIconLbl.setPadding(new Insets(5, 5, 5, 10));
        
        
        
        checkOut.getStyleClass().add("btn");
        
        searchBar.getChildren().addAll(searchIconLbl, searchTxt);
        searchBtn.getChildren().addAll(searchBar, checkOut);
        
        table.setEditable(false);
        
        
        table.getColumns().addAll(id, roomid, firstName, middleName, lastName, idcard, email, phone, gender, status,address ,arriveDate ,numOfDays, foodid, carid, privatedriver );

        
        
        search.getChildren().addAll(searchBtn, table);
        search.setPadding(new Insets(100, 150, 0, 0));
        
        
        page.setTop(logoView);
        page.setLeft(sideMenu);
        page.setCenter(search);
        
        Scene scene = new Scene(page, 1920, 1050);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/CheckOut/ChooseGuest/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

}
