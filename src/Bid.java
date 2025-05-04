import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bid {
    private final int id;
    private final double bidAmount;
    private final User Bidder;
    private LocalDate time;


    public Bid(int id, User bidder, double bidAmount) {
        this.id = id;
        this.bidAmount = bidAmount;
        Bidder = bidder;
        time = LocalDate.now();
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public User getBidder() {
        return Bidder;
    }

    public LocalDate getTime() {
        return time;
    }

    public int getId() {
        return id;
    }
}


/*
Bid amount
Bidder name(User)
Time
 */