import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionSystem {
    private static AuctionSystem instance;
    private final Map<Integer, User> users;
    private final Map<Integer, AuctionListing> auctionListings;

    public AuctionSystem() {
        this.users = new ConcurrentHashMap<>();
        this.auctionListings = new ConcurrentHashMap<>();
    }

    public static AuctionSystem getInstance(){
        if(instance == null) return new AuctionSystem();
        return instance;
    }

    public void registerUser(int id, User user){
        users.put(id, user);
    }

    public void createAuctionListing(int id, AuctionListing auctionListing){
        auctionListings.put(id, auctionListing);
        startAuctionTimer(auctionListing);
    }

    public List<AuctionListing> searchAuctionListings(String keyword){
        List<AuctionListing> filterResult = new ArrayList<>();
        for(AuctionListing auctionListing: auctionListings.values()){
            if(auctionListing.getItemName().contains(keyword) || auctionListing.getDescription().contains(keyword)){
                filterResult.add(auctionListing);
            }
        }
        return filterResult;
    }

    public synchronized void placeBid(int id, Bid bid) throws ClassNotFoundException {
        AuctionListing auctionListing = auctionListings.get(id);
        if(auctionListing != null && auctionListing.getAuctionStatus() == AuctionStatus.ACTIVE){
            if(auctionListing.getHighestBid() < bid.getBidAmount()){
//              Only add when it is greater than the highest bid
                auctionListing.bids.add(bid);
                auctionListing.setHighestBid(bid.getBidAmount());
                auctionListing.setHighestBidder(bid.getBidder());
            }
        }
        else throw new ClassNotFoundException("Auction Not found.");
    }

    public void startAuctionTimer(AuctionListing auctionListing){
//        This is something which I should remember
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public synchronized void run() {
                auctionListing.setAuctionStatus(AuctionStatus.CLOSED);
                notifyUser(auctionListing);
            }
        }, auctionListing.getDuration());
    }

    private void notifyUser(AuctionListing auctionListing) {
//        Logic for PUB SUB System
        System.out.println(auctionListing.getHighestBid());
        System.out.println(auctionListing.getHighestBidder().getName());
    }

}

//RegisterUser
//Create Auction -> Start Auction Timer
//Place Bid
//Search Auction (Keyword can either be in Item name and Description)