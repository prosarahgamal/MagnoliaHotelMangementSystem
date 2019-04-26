
package LoginPage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface{

    private Image logo;
    
    static Button manager;
    static Button receptionist;
    static Button loginBtn;
    
    Stage primaryStage;
    
    Label username;
    TextField usernameTxt;
    Label password;
    PasswordField passwordTxt;
    
    public Interface(){
        logo = new Image("/images/logo.png");
        manager = new Button("MANAGER");
        receptionist = new Button("RECEPTIONIST");
        loginBtn = new Button("LOGIN");
        
        manager.setFocusTraversable(false);
        
        username = new Label("USERNAME");
        usernameTxt = new TextField();
        password = new Label("PASSWORD");
        passwordTxt = new PasswordField();
    }
    
    public void start() {
        
        primaryStage = new Stage();
        
        BorderPane borderPane = new BorderPane();
        BorderPane loginPane = new BorderPane();
        HBox tabs = new HBox(30);
        VBox rightBox = new VBox(70);
        VBox usernameBox = new VBox(20);
        VBox passwordBox = new VBox(20);
        HBox loginBtnBox = new HBox();
        
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
        
        tabs.setAlignment(Pos.CENTER);
        tabs.setPadding(new Insets(20));
        
        rightBox.setPadding(new Insets(40, 80, 0, 50));
        
        loginBtnBox.setPadding(new Insets(0, 0, 0, 250));
        
        
        manager.getStyleClass().add("tab");
        receptionist.getStyleClass().add("tab");
        tabs.getChildren().addAll(manager, receptionist);
        
        ToggleGroup tabsGroup = new ToggleGroup();
        
        
        
        ImageView logoView = new ImageView(logo);
        logoView.getStyleClass().add("logoview");
        
        
        
        username.getStyleClass().add("lbl");
        password.getStyleClass().add("lbl");
        usernameTxt.getStyleClass().add("txtbox");
        passwordTxt.getStyleClass().add("txtbox");
        
        
        
        loginBtn.getStyleClass().add("loginbtn");
        loginBtnBox.getChildren().add(loginBtn);

        usernameBox.getChildren().addAll(username, usernameTxt);
        passwordBox.getChildren().addAll(password,passwordTxt);
        rightBox.getChildren().addAll(usernameBox, passwordBox,loginBtnBox);
        
        loginPane.setTop(tabs);
        loginPane.setLeft(logoView);
        loginPane.setRight(rightBox);
        
        borderPane.setTop(topSpace);
        borderPane.setLeft(leftSpace);
        borderPane.setRight(rightSpace);
        borderPane.setBottom(bottomSpace);
        
        borderPane.setCenter(loginPane);
        
        Scene scene = new Scene(borderPane, 1800, 1200);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/LoginPage/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
