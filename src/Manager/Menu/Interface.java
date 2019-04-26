
package Manager.Menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface{

    private final Image logo = new Image("/images/logo.png");
    Stage primaryStage;
    
    Image manageRooms = new Image("images/menu/manager/managerooms.png");
    Image manageStaff = new Image("images/menu/manager/managestaff.png");
    Image account = new Image("images/menu/account.png");
    Image logout = new Image("images/menu/logout.png");
    
    Image manageRoomshover = new Image("images/menu/manager/manageroomshover.png");
    Image manageStaffhover = new Image("images/menu/manager/managestaffhover.png");
    Image accounthover = new Image("images/menu/accounthover.png");
    Image logouthover = new Image("images/menu/logouthover.png");
    
    
    ImageView manageRoomsView = new ImageView(manageRooms);
    ImageView manageStaffView = new ImageView(manageStaff);
    ImageView accountView = new ImageView(account);
    ImageView logoutView = new ImageView(logout);
    
    Button manageRoomsBtn = new Button("\t\tManage Rooms", manageRoomsView);
    Button manageStaffBtn = new Button("\t\tManage Staff", manageStaffView);
    Button accountBtn = new Button("\t\tAccount", accountView);
    Button logoutBtn = new Button("\t\tLogOut", logoutView);
    
    public void start() {
        
        primaryStage = new Stage();
        
        BorderPane borderPane = new BorderPane();
        BorderPane loginPane = new BorderPane();
        VBox menuList = new VBox(5);
        
        //panes for spaces hence fx doesn't support margin
        Pane leftSpace = new Pane();
        Pane topSpace = new Pane();
        Pane rightSpace = new Pane();
        Pane bottomSpace = new Pane();
        leftSpace.setMinWidth(450);
        rightSpace.setMinWidth(450);
        topSpace.setMinHeight(200);
        bottomSpace.setMinHeight(200);
        
        loginPane.getStyleClass().add("loginPane");

        ImageView logoView = new ImageView(logo);
        logoView.getStyleClass().add("logoview");
        
        manageRoomsView.setFitWidth(50);
        manageRoomsView.setFitHeight(50);
        
        manageStaffView.setFitWidth(50);
        manageStaffView.setFitHeight(50);
        
        accountView.setFitWidth(40);
        accountView.setFitHeight(40);
        
        logoutView.setFitWidth(40);
        logoutView.setFitHeight(40);

        
        
        manageRoomsBtn.setPadding(new Insets(10, 0, 0, 30));
        manageRoomsBtn.setAlignment(Pos.TOP_LEFT);
        manageRoomsBtn.getStyleClass().add("btn");
        
        manageStaffBtn.setPadding(new Insets(10, 0, 0, 30));
        manageStaffBtn.setAlignment(Pos.TOP_LEFT);
        manageStaffBtn.getStyleClass().add("btn");
        

        
        accountBtn.setPadding(new Insets(15, 0, 0, 40));
        accountBtn.setAlignment(Pos.TOP_LEFT);
        accountBtn.getStyleClass().add("btn");
        
        logoutBtn.setPadding(new Insets(15, 0, 0, 40));
        logoutBtn.setAlignment(Pos.TOP_LEFT);
        logoutBtn.getStyleClass().add("btn");

        menuList.getChildren().addAll(manageRoomsBtn, manageStaffBtn, accountBtn, logoutBtn);
        menuList.setPadding(new Insets(100, 0, 0, 40));
        
        
        manageRoomsBtn.setOnMouseEntered(e -> {
            manageRoomsView.setImage(manageRoomshover);
        });
        manageRoomsBtn.setOnMouseExited(e -> {
            manageRoomsView.setImage(manageRooms);
        });
        
        manageStaffBtn.setOnMouseEntered(e -> {
            manageStaffView.setImage(manageStaffhover);
        });
        manageStaffBtn.setOnMouseExited(e -> {
            manageStaffView.setImage(manageStaff);
        });
        
        accountBtn.setOnMouseEntered(e -> {
            accountView.setImage(accounthover);
        });
        accountBtn.setOnMouseExited(e -> {
            accountView.setImage(account);
        });
        
        logoutBtn.setOnMouseEntered(e -> {
            logoutView.setImage(logouthover);
        });
        logoutBtn.setOnMouseExited(e -> {
            logoutView.setImage(logout);
        });

        loginPane.setRight(logoView);
        BorderPane.setAlignment(logoView, Pos.CENTER);
        loginPane.setLeft(menuList);

        borderPane.setTop(topSpace);
        borderPane.setLeft(leftSpace);
        borderPane.setRight(rightSpace);
        borderPane.setBottom(bottomSpace);
        
        borderPane.setCenter(loginPane);
        
        Scene scene = new Scene(borderPane, 1800, 1200);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Manager/Menu/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
        
        
        
        
        
    }
}
