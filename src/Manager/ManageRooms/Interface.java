
package Manager.ManageRooms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    
    TableView table;
    
    TableColumn roomId;
    TableColumn roomType;
    TableColumn roomView;
    TableColumn isSmokable;
    TableColumn isReserved;
    TableColumn cost;
    TableColumn reservationCounter;
    TableColumn lastCheckIn;
    TableColumn isDeactivated;
    TableColumn rate;
    
    Image addRoom;
    Image editRoom;
    Image deactiveRoom;
    
    Image addRoomHover;
    Image editRoomHover;
    Image deactiveRoomHover;
    
    ImageView addRoomView;
    ImageView editRoomView;
    ImageView deactivateRoomView;
    
    Image searchIcon;
    ImageView searchIconView;
    TextField searchTxt;
    
    Label roomTypeLbl = new Label("Room Type");
    Label roomViewLbl = new Label("Room View");
    Label costLbl = new Label("Cost Per Day");
    
    ComboBox<String> roomTypeComboBox;
        
    ComboBox<String> roomViewComboBox;
        
    TextField costTxt;

    CheckBox smokableCheckBox;
    CheckBox deactiveCheckBox;
    
    Button addBtn;
    Button editBtn;
    
    ImageView accountView;
    ImageView menuView;
    
    public Interface (){
        
        primaryStage = new Stage();
    
        table = new TableView();
        
        roomId = new TableColumn("Room ID");
        roomType = new TableColumn("Room Type");
        roomView = new TableColumn("Room View");
        isSmokable = new TableColumn("Smokable");
        isReserved = new TableColumn("Reserved");
        cost = new TableColumn("Cost Per Night");
        reservationCounter = new TableColumn("Reservation Counter");
        lastCheckIn = new TableColumn("Last CheckIn");
        isDeactivated = new TableColumn("is deactiveated");
        rate = new TableColumn("Rate");
        
        accountView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.account);
        menuView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.menu);
        
        addRoom = new Image("images/manage/room/addroom.png");
        editRoom = new Image("images/manage/room/editroom.png");
        deactiveRoom = new Image("images/manage/deactive.png");
        
        addRoomHover = new Image("images/manage/room/addroomhover.png");
        editRoomHover = new Image("images/manage/room/editroomhover.png");
        deactiveRoomHover = new Image("images/manage/deactivehover.png");
        
        addRoomView = new ImageView(addRoom);
        editRoomView = new ImageView(editRoom);
        deactivateRoomView = new ImageView(deactiveRoom);
        
        searchTxt = new TextField();
        searchIcon = new Image("/images/search.png");
        searchIconView = new ImageView(searchIcon);
        
        roomTypeComboBox = new ComboBox<>();
        roomTypeComboBox.getItems().addAll("Single", "Double", "Triple", "Quad", "Queen", "King", "Studio");
        roomTypeComboBox.getSelectionModel().selectFirst();


        
        roomViewComboBox = new ComboBox<>();
        roomViewComboBox.getItems().addAll("Green", "Blue");
        roomViewComboBox.getSelectionModel().selectFirst();
        
        costTxt = new TextField("");
        
        smokableCheckBox = new CheckBox("Smokable");
        deactiveCheckBox = new CheckBox("Deactive");
        
        addBtn = new Button(" Add", addRoomView);
        editBtn = new Button(" Edit", editRoomView);
    }

    public void start()  {

        BorderPane page = new BorderPane();
        
        VBox sideMenu = new VBox(50);
        HBox searchBar = new HBox();
        VBox centerPane = new VBox();
        
        VBox rightPane = new VBox(30);
        
        VBox editInfo = new VBox(20);
        
        VBox btns = new VBox(20);
        
        ImageView logoView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        
        
        
        sideMenu.getChildren().addAll(accountView, menuView);
        sideMenu.setPadding(new Insets(300, 50, 0, 20));
        
        Label searchIconLbl = new Label("",searchIconView);
        searchIconLbl.getStyleClass().add("searchLbl");
        searchIconLbl.setContentDisplay(ContentDisplay.CENTER);
        searchIconLbl.setPadding(new Insets(5, 5, 5, 10));
        
        
        searchTxt.getStyleClass().add("search");
        
        searchBar.getChildren().addAll(searchIconLbl, searchTxt);
        
        
        
        
        editInfo.getChildren().addAll(roomTypeLbl, roomTypeComboBox, roomViewLbl, roomViewComboBox, costLbl, costTxt, smokableCheckBox, deactiveCheckBox);
        editInfo.setPadding(new Insets(20, 50, 0, 50));

        
        addRoomView.setFitHeight(30);
        addRoomView.setFitWidth(30);
        
        editRoomView.setFitHeight(30);
        editRoomView.setFitWidth(30);
        
        deactivateRoomView.setFitHeight(30);
        deactivateRoomView.setFitWidth(30);

        addBtn.setAlignment(Pos.CENTER_LEFT);
        
        
        editBtn.setAlignment(Pos.CENTER_LEFT);
        
        Button deactivateBtn = new Button(" Deactivate", deactivateRoomView);
        deactivateBtn.setAlignment(Pos.CENTER_LEFT);
        
        btns.getChildren().addAll(addBtn, editBtn);
        btns.setPadding(new Insets(100, 50, 0, 50));
        
        
        rightPane.getChildren().addAll(editInfo, btns);
        rightPane.getStyleClass().add("rightpane");
        
        table.getColumns().addAll(roomId, roomType, roomView, isSmokable, isReserved, cost, reservationCounter, lastCheckIn, isDeactivated, rate);

        
        centerPane.getChildren().addAll(searchBar , table);
        centerPane.setPadding(new Insets(50));
        
        
        addBtn.setOnMouseEntered(e -> {
            addRoomView.setImage(addRoomHover);
        });
        addBtn.setOnMouseExited(e -> {
            addRoomView.setImage(addRoom);
        });
        
        editBtn.setOnMouseEntered(e -> {
            editRoomView.setImage(editRoomHover);
        });
        editBtn.setOnMouseExited(e -> {
            editRoomView.setImage(editRoom);
        });
        
        deactivateBtn.setOnMouseEntered(e -> {
            deactivateRoomView.setImage(deactiveRoomHover);
        });
        deactivateBtn.setOnMouseExited(e -> {
            deactivateRoomView.setImage(deactiveRoom);
        });
        
        
        page.setTop(logoView);
        page.setCenter(centerPane);
        page.setLeft(sideMenu);
        page.setRight(rightPane);


        Scene scene = new Scene(page, 1800, 1200);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Manager/ManageRooms/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
