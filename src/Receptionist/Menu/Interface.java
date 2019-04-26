
package Receptionist.Menu;

import javafx.application.Application;
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
    
    Image checkin = new Image("images/menu/receptionist/checkin.png");
    Image checkout = new Image("images/menu/receptionist/checkout.png");
    Image update = new Image("images/menu/receptionist/update.png");
    Image account = new Image("images/menu/account.png");
    Image logout = new Image("images/menu/logout.png");
    
    Image checkinhover = new Image("images/menu/receptionist/checkinhover.png");
    Image checkouthover = new Image("images/menu/receptionist/checkouthover.png");
    Image updatehover = new Image("images/menu/receptionist/updatehover.png");
    Image accounthover = new Image("images/menu/accounthover.png");
    Image logouthover = new Image("images/menu/logouthover.png");
    
    
    ImageView checkinView = new ImageView(checkin);
    ImageView checkoutView = new ImageView(checkout);
    ImageView updateView = new ImageView(update);
    ImageView accountView = new ImageView(account);
    ImageView logoutView = new ImageView(logout);
    
    Button checkinBtn = new Button("\t\tCheckIn", checkinView);
    Button checkOutBtn = new Button("\t\tCheckOut", checkoutView);
    Button updateBtn = new Button("\t\tUpdate", updateView);
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
        
        checkinView.setFitWidth(50);
        checkinView.setFitHeight(50);
        
        checkoutView.setFitWidth(50);
        checkoutView.setFitHeight(50);
        
        updateView.setFitWidth(40);
        updateView.setFitHeight(40);
        
        accountView.setFitWidth(40);
        accountView.setFitHeight(40);
        
        logoutView.setFitWidth(40);
        logoutView.setFitHeight(40);

        
        
        checkinBtn.setPadding(new Insets(10, 0, 0, 30));
        checkinBtn.setAlignment(Pos.TOP_LEFT);
        checkinBtn.getStyleClass().add("btn");
        
        checkOutBtn.setPadding(new Insets(10, 0, 0, 30));
        checkOutBtn.setAlignment(Pos.TOP_LEFT);
        checkOutBtn.getStyleClass().add("btn");
        
        updateBtn.setPadding(new Insets(15, 0, 0, 40));
        updateBtn.setAlignment(Pos.TOP_LEFT);
        updateBtn.getStyleClass().add("btn");
        
        accountBtn.setPadding(new Insets(15, 0, 0, 40));
        accountBtn.setAlignment(Pos.TOP_LEFT);
        accountBtn.getStyleClass().add("btn");
        
        logoutBtn.setPadding(new Insets(15, 0, 0, 40));
        logoutBtn.setAlignment(Pos.TOP_LEFT);
        logoutBtn.getStyleClass().add("btn");

        menuList.getChildren().addAll(checkinBtn, checkOutBtn, updateBtn, accountBtn, logoutBtn);
        menuList.setPadding(new Insets(80, 0, 0, 40));
        
        
        checkinBtn.setOnMouseEntered(e -> {
            checkinView.setImage(checkinhover);
        });
        checkinBtn.setOnMouseExited(e -> {
            checkinView.setImage(checkin);
        });
        
        checkOutBtn.setOnMouseEntered(e -> {
            checkoutView.setImage(checkouthover);
        });
        checkOutBtn.setOnMouseExited(e -> {
            checkoutView.setImage(checkout);
        });
        
        updateBtn.setOnMouseEntered(e -> {
            updateView.setImage(updatehover);
        });
        updateBtn.setOnMouseExited(e -> {
            updateView.setImage(update);
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
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/Menu/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
        
        
        
        
        
    }
}
