
package Receptionist.Update;

import static Receptionist.CheckIn.RoomInfo.Interface.account;
import static Receptionist.CheckIn.RoomInfo.Interface.menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    
    Image searchIcon = new Image("/images/search.png");
    ImageView searchIconView = new ImageView(searchIcon);
    TableView table = new TableView();

    public void start() {
        
        Stage primaryStage = new Stage();
        
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
        
        TextField searchTxt = new TextField();
        searchTxt.getStyleClass().add("search");
        
        TextField updateValue = new TextField();
        updateValue.setAlignment(Pos.CENTER);
        updateValue.getStyleClass().add("updateValue");
        
        Button update = new Button("UPDATE");
        update.getStyleClass().add("btn");
        
        
        searchBar.getChildren().addAll(searchIconLbl, searchTxt);
        searchBtn.getChildren().addAll(searchBar,updateValue, update);
        
        table.setEditable(false);
        TableColumn guestId = new TableColumn("Guest ID");
        TableColumn firstName = new TableColumn("First Name");
        TableColumn middleName = new TableColumn("Middle Name");
        TableColumn lastName = new TableColumn("Last Name");
        TableColumn id = new TableColumn("ID");
        TableColumn email = new TableColumn("E-Mail");
        TableColumn mobile = new TableColumn("Mobile");
        TableColumn numOfDays = new TableColumn("Num Of Days");
        TableColumn genera = new TableColumn("Genera");
        TableColumn updateable = new TableColumn("Updateable");
        TableColumn status = new TableColumn("Status");
        TableColumn address = new TableColumn("Address");
        TableColumn roomId = new TableColumn("Room ID");
        
        table.getColumns().addAll(guestId, roomId, firstName, middleName, lastName, id, email, mobile, numOfDays, genera, updateable, status, address);
        
        search.getChildren().addAll(searchBtn, table);
        search.setPadding(new Insets(100, 150, 0, 0));
        
        
        menuView.setOnMouseClicked(e -> {
            new Receptionist.Menu.Interface().start();
            primaryStage.close();
        });
        
        
        page.setTop(logoView);
        page.setLeft(sideMenu);
        page.setCenter(search);
        
        Scene scene = new Scene(page, 1920, 1050);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/Update/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

}
