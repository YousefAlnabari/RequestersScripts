import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class Requester {

    // List of user agents to simulate different browsers
    private static String[] userAgents = {
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.1000.0 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:100.0) Gecko/20100101 Firefox/100.0",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.1000.0 Safari/537.36"
            // Add more user agents as needed
    };

    // Number of requests to send for each user agent
    private static int numRequests = 10;

    // URL to send requests to
    private static String url = "https://yousef.cloud/";

    // Logger for logging
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // Function to send requests
    private static void sendRequests(String urlString, String userAgent) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", userAgent);
            int responseCode = connection.getResponseCode();
            logger.info("Response from " + userAgent + ": " + responseCode);
        } catch (IOException e) {
            logger.severe("Error with " + userAgent + ": " + e.getMessage());
        }
    }

    // Send requests
    public static void main(String[] args) {
        for (String userAgent : userAgents) {
            for (int i = 0; i < numRequests; i++) {
                sendRequests(url, userAgent);
            }
        }
    }
}
