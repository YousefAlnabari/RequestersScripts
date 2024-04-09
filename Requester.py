import requests
import random

# List of user agents to simulate different browsers
user_agents = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.1000.0 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:100.0) Gecko/20100101 Firefox/100.0",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.1000.0 Safari/537.36"
    # Add more user agents as needed
]

# Number of requests to send for each user agent
num_requests = 10

# URL to send requests to
url = "https://yousef.cloud/"

# Function to send requests
def send_requests(url, user_agent):
    headers = {'User-Agent': user_agent}
    try:
        response = requests.get(url, headers=headers)
        print(f"Response from {user_agent}: {response.status_code}")
    except Exception as e:
        print(f"Error with {user_agent}: {str(e)}")

# Send requests
for user_agent in user_agents:
    for _ in range(num_requests):
        send_requests(url, user_agent)
