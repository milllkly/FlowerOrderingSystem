package singleton;

public class DatabaseConnection {
    private static DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {
        // private constructor to prevent external instantiation
        // Initialize your database connection here
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    // Mock method to simulate database operation
    public void saveOrderDetails(String orderDetails) {
        System.out.println("Saving order details to database: " + orderDetails);
    }

    // Additional database methods as needed
}
