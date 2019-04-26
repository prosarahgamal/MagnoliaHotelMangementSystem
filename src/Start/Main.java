package Start;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;



/**
 *
 * @author Sara
 */
public class Main extends Application{
    
    
    public static ArrayList<Models.Accounts> accounts = new ArrayList<>();
    public static ArrayList<Models.Rooms> rooms = new ArrayList<>();
    public static ArrayList<Models.Guests> guests = new ArrayList<>();
    public static ArrayList<Models.Bills> bills = new ArrayList<>();
    public static ArrayList<Models.Cars> cars = new ArrayList<>();
    public static ArrayList<Models.Food> food = new ArrayList<>();
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        new LoginPage.Control();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
