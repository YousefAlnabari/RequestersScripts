const fetch = require('node-fetch');

// List of user agents to simulate different browsers
const userAgents = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.1000.0 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:100.0) Gecko/20100101 Firefox/100.0",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.1000.0 Safari/537.36"
    // Add more user agents as needed
];

// Number of requests to send for each user agent
const numRequests = 10;

// URL to send requests to
const url = "https://yousef.cloud/";

// Function to send requests
async function sendRequests(url, userAgent) {
    const headers = {'User-Agent': userAgent};
    try {
        const response = await fetch(url, { headers });
        console.log(`Response from ${userAgent}: ${response.status}`);
    } catch (error) {
        console.error(`Error with ${userAgent}: ${error}`);
    }
}

// Send requests
async function main() {
    for (const userAgent of userAgents) {
        for (let i = 0; i < numRequests; i++) {
            await sendRequests(url, userAgent);
        }
    }
}

main();
