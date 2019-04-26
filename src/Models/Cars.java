
package Models;

/**
 *
 * @author Sara
 */
public class Cars {
    
    private long id;
    private String type;
    private double cost;

    public Cars(long id, String type, double cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
}
