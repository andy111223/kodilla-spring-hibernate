import csv
import random
from datetime import datetime, timedelta

def generate_name():
    first_names = ["John", "Jane", "Alex", "Alice", "Michael", "Michelle", "Chris", "Christina", "David", "Dana"]
    last_names = ["Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"]
    return random.choice(first_names), random.choice(last_names)

def generate_birthdate():
    start_date = datetime(1950, 1, 1)
    end_date = datetime(2000, 12, 31)
    random_date = start_date + timedelta(days=random.randint(0, (end_date - start_date).days))
    return random_date.strftime('%Y-%m-%d')

file_path = 'input.csv'

with open(file_path, mode='w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(["firstName", "lastName", "birthdate"])
    for _ in range(1000):
        first_name, last_name = generate_name()
        birthdate = generate_birthdate()
        writer.writerow([first_name, last_name, birthdate])

print(f"CSV file '{file_path}' created with 1000 rows.")
