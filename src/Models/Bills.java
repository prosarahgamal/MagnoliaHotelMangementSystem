
package Models;

/**
 *
 * @author Sara
 */
public class Bills {
    
    private long id;
    private long guestId;
    private long receptionistId;
    private double totalAmount;

    public Bills(long id, long guestId, long receptionistId, double totalAmount) {
        this.id = id;
        this.guestId = guestId;
        this.receptionistId = receptionistId;
        this.totalAmount = totalAmount;
    }

    
    public long getId() {
        return id;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public long getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(long receptionistId) {
        this.receptionistId = receptionistId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    
}
