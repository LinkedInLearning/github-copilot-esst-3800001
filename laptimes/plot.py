import requests
from datetime import datetime
import matplotlib.pyplot as plt

# Fetch lap times
response = requests.get('http://localhost:8080/api/laptimes')
lap_times = response.json()

# Parse lap times
times = [lap_time['lapTime'] for lap_time in lap_times]

# Plot lap time distribution
plt.hist(times, bins=20, edgecolor='black')
plt.xlabel('Lap Time')
plt.ylabel('Frequency')
plt.title('Lap Time Distribution')

# Save plot to a file
plt.savefig('lap_times_distribution.png')