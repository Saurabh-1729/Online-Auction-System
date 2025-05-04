import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AuctionSystemDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        AuctionSystem auctionSystem = AuctionSystem.getInstance();

        // Register users
        User user1 = new User(1, "John Doe", "john@example.com");
        User user2 = new User(2, "Jane Smith", "jane@example.com");
        auctionSystem.registerUser(1, user1);
        auctionSystem.registerUser(2, user2);

        // Create auction listings
        AuctionListing listing1 = new AuctionListing(1, "Item 1", "Description 1", 100.0, 600, user1);
        AuctionListing listing2 = new AuctionListing(2, "Item 2", "Description 2", 50.0, 1200, user2);
        auctionSystem.createAuctionListing(1, listing1);
        auctionSystem.createAuctionListing(2, listing2);

        // Search auction listings
        List<AuctionListing> searchResults = auctionSystem.searchAuctionListings("Item");
        System.out.println("Search Results:");
        for (AuctionListing listing : searchResults) {
            System.out.println(listing.getItemName());
        }

        // Place bids
        Bid bid1 = new Bid(1, user2, 150.0);
        Bid bid2 = new Bid(2, user1, 200.0);
        auctionSystem.placeBid(listing1.getId(), bid1);
        auctionSystem.placeBid(listing1.getId(), bid2);
    }
}

/*
The online auction system should allow users to register and log in to their accounts.
Users should be able to create new auction listings with details such as item name, description, starting price, and auction duration.
Users should be able to browse and search for auction listings based on various criteria (e.g., item name, category, price range).
Users should be able to place bids on active auction listings.
The system should automatically update the current highest bid and notify the bidders accordingly.
The auction should end when the specified duration is reached, and the highest bidder should be declared the winner.
The system should handle concurrent access to auction listings and ensure data consistency.
The system should be extensible to accommodate future enhancements and new features.
 */


//Two main things:
//1. LocalDate to store data of date types
//2. There is a method to get the dates between to localdates.
//3. Timer method to trigger some even after a particular time interval.
