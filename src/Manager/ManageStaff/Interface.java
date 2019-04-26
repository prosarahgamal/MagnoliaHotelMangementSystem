
package Manager.ManageStaff;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Saras
 */
public class Interface {
    
    Stage primaryStage;
    TableView table = new TableView();
    
    ImageView accountView;
        ImageView menuView;
    
    Image searchIcon = new Image("/images/search.png");
    ImageView searchIconView = new ImageView(searchIcon);
    
    TableColumn UserId = new TableColumn("ID");
    TableColumn username = new TableColumn("UserName");
    TableColumn password = new TableColumn("Password");
    TableColumn firstname = new TableColumn("FirstName");
    TableColumn lastname = new TableColumn("LastName");
    TableColumn email = new TableColumn("E-mail");
    TableColumn phone = new TableColumn("Phone");
    TableColumn salary = new TableColumn("Salary");
    TableColumn address = new TableColumn("Address");
    TableColumn bio = new TableColumn("Bio");
    TableColumn isManager = new TableColumn("Manager");
    TableColumn isDeactivated = new TableColumn("Deactivated");
    
    Image addUser = new Image("images/manage/user/adduser.png");
    Image editUser = new Image("images/manage/user/edituser.png");
    Image deactiveUser = new Image("images/manage/deactive.png");
    Image deleteUser = new Image("images/manage/user/deleteuser.png");
    
    Image addUserHover = new Image("images/manage/user/adduserhover.png");
    Image editUserHover = new Image("images/manage/user/edituserhover.png");
    Image deactiveUserHover = new Image("images/manage/deactivehover.png");
    Image deleteUserHover = new Image("images/manage/user/deleteuserhover.png");
    
    ImageView addUserView = new ImageView(addUser);
    ImageView editUserView = new ImageView(editUser);
    ImageView deactivateUserView = new ImageView(deactiveUser);
    ImageView deleteUserView = new ImageView(deleteUser);
    
    Image profilepicture;
    ImageView profilePictureView;
    
    TextField[] infoTextFields = new TextField[8];
    
    TextArea bioTxt = new TextArea();
    
    CheckBox isManagerCK = new CheckBox("Manager");
    CheckBox deactive = new CheckBox("Deactive");
    
    TextField searchTxt;
    
    Button addUserBtn;
    Button editUserBtn;
    Button deleteUserBtn;
    
    public Interface(){
        
        accountView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.account);
        menuView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.menu);
        
        infoTextFields[0] = new TextField();
        infoTextFields[0].setPromptText("UserName");
        
        infoTextFields[1] = new TextField();
        infoTextFields[1].setPromptText("Password");
        
        infoTextFields[2] = new TextField();
        infoTextFields[2].setPromptText("FirstName");
        
        infoTextFields[3] = new TextField();
        infoTextFields[3].setPromptText("LastName");
        
        infoTextFields[4] = new TextField();
        infoTextFields[4].setPromptText("Email");
        
        infoTextFields[5] = new TextField();
        infoTextFields[5].setPromptText("Phone");
        
        infoTextFields[6] = new TextField();
        infoTextFields[6].setPromptText("Address");
        
        infoTextFields[7] = new TextField();
        infoTextFields[7].setPromptText("Salary");
        
        bioTxt.setPromptText("BiO");
        
        addUserView.setFitHeight(30);
        addUserView.setFitWidth(30);
        
        editUserView.setFitHeight(30);
        editUserView.setFitWidth(30);
        
        deactivateUserView.setFitHeight(30);
        deactivateUserView.setFitWidth(30);
        
        deleteUserView.setFitHeight(30);
        deleteUserView.setFitWidth(30);
        
        table.getColumns().addAll(UserId, username, password, firstname, lastname, email, phone, salary, address, bio, isManager, isDeactivated);
        
        searchTxt = new TextField();
        
        editUserBtn = new Button("Edit User", editUserView);
        addUserBtn = new Button("Add User", addUserView);
        deleteUserBtn = new Button("Delete User", deleteUserView);
        
    }

    
    public void start() {
        
        primaryStage = new Stage();
        
        BorderPane page = new BorderPane();
        VBox sideMenu = new VBox(50);
        HBox searchBar = new HBox();
        VBox center = new VBox();
        
        VBox right = new VBox();
        VBox btns = new VBox();
        
        VBox info = new VBox();
        
        HBox infoFields = new HBox(10);
        VBox infoFields1 = new VBox(5);
        VBox infoFields2 = new VBox(5);

        
        
        ImageView logoView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        
        
        sideMenu.getChildren().addAll(accountView, menuView);
        sideMenu.setPadding(new Insets(300, 50, 0, 20));
        
        Label searchIconLbl = new Label("",searchIconView);
        searchIconLbl.setContentDisplay(ContentDisplay.CENTER);
        searchIconLbl.setPadding(new Insets(5, 5, 5, 10));
        
        
        searchTxt.getStyleClass().add("search");
        
        searchBar.getChildren().addAll(searchIconLbl, searchTxt);

        center.getChildren().addAll(searchBar, table);
        
        for (int i = 0; i < infoTextFields.length; i++) {
            infoTextFields[i].setStyle("-fx-pref-width: 190px;");
            
        }
        
        infoFields1.getChildren().addAll(infoTextFields[0], infoTextFields[2], infoTextFields[4], infoTextFields[6], isManagerCK);
        infoFields2.getChildren().addAll(infoTextFields[1], infoTextFields[3], infoTextFields[5], infoTextFields[7], deactive);
        infoFields.getChildren().addAll(infoFields1, infoFields2);
        
        profilePictureView = new ImageView();
        profilePictureView.setFitHeight(200);
        profilePictureView.setFitWidth(200);
        
        bioTxt.setMaxSize(400, 100);
        
        info.getChildren().addAll( profilePictureView, infoFields, bioTxt);
        
        btns.getChildren().addAll(addUserBtn, editUserBtn, deleteUserBtn);
        
        addUserBtn.setAlignment(Pos.CENTER_LEFT);
        editUserBtn.setAlignment(Pos.CENTER_LEFT);
        deleteUserBtn.setAlignment(Pos.CENTER_LEFT);
        
        right.getChildren().addAll(info, btns);
        right.getStyleClass().add("right");
        right.setPadding(new Insets(50));
        
        
        addUserBtn.setOnMouseEntered(e -> {
            addUserView.setImage(addUserHover);
        });
        addUserBtn.setOnMouseExited(e -> {
            addUserView.setImage(addUserHover);
        });
        
        editUserBtn.setOnMouseEntered(e -> {
            editUserView.setImage(editUserHover);
        });
        editUserBtn.setOnMouseExited(e -> {
            editUserView.setImage(editUserHover);
        });
        
        deleteUserBtn.setOnMouseEntered(e -> {
            deleteUserView.setImage(deleteUserHover);
        });
        deleteUserBtn.setOnMouseExited(e -> {
            deleteUserView.setImage(deleteUserHover);
        });
        
        page.setCenter(center);
        page.setTop(logoView);
        page.setLeft(sideMenu);
        page.setRight(right);


        Scene scene = new Scene(page, 1800, 1200);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Manager/ManageStaff/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
}
