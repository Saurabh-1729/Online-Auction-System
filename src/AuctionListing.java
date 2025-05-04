import java.util.ArrayList;
import java.util.List;

public class AuctionListing {
    private final int id;
    private final String itemName;
    private final String Description;
    private final double startingPrice;
    private final long duration;
    private final User seller;
    List<Bid> bids;
    private double highestBid;
    private User highestBidder;
    private AuctionStatus auctionStatus;

    public AuctionListing(int id, String itemName, String description, double startingPrice, long duration, User seller) {
        this.id = id;
        this.itemName = itemName;
        this.Description = description;
        this.startingPrice = startingPrice;
        this.duration = duration;
        this.seller = seller;
        bids = new ArrayList<>();
        auctionStatus = AuctionStatus.ACTIVE;
        highestBidder = null;
        highestBid = startingPrice;
    }

    public int getId() {
        return id;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public String getDescription() {
        return Description;
    }

    public String getDescription(String description) {
        return this.Description;
    }

    public long getDuration() {
        return duration;
    }

    public double getHighestBid() {
        return  highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public User getHighestBidder() {
        return highestBidder;
    }

    public void setHighestBidder(User highestBidder) {
        this.highestBidder = highestBidder;
    }

    public String getItemName() {
        return itemName;
    }

    public User getSeller() {
        return seller;
    }

    public double getStartingPrice() {
        return startingPrice;
    }
}

/*
    id
    item name
    Description
    Starting Price
    Duration
    Seller(User)
    List of Bids
    Highest Bid(Amount)
    Highest Bidder(User)
    Auction Status(Active, Deleted, Closed)
 */
