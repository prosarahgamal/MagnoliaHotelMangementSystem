package AlertBox;

/**
 *
 * @author Sara
 */
public class Action {
    
    public static int action(String mess){
    
        int flag = 0;
        
        flag = Interface.display(mess);

        return flag;
    }
    
    
}
