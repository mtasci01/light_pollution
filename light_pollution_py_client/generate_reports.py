import random
from pandas import read_csv
import requests

def read_csv_in_list(filepath):
    df_data = read_csv(filepath)
    cities_list=[]
    
    for index, row in df_data.iterrows():
        
        obj ={
            "city":row['capital'],
            "country":row['hckey'],
            "lat":row['capital_lat'],
            "lon":row['capital_lng']
        }
        cities_list.append(obj)
    return cities_list

cities = read_csv_in_list("cities_europe.csv")
print(cities)

batches = 10
per_batch = 10

for i in range(batches):
    data =[]
    for y in range(per_batch):
        city_obj = random.choice(cities)
        severity = random.randint(0,5)
        data_obj = {
            "lat":city_obj['lat'],
            "lon":city_obj['lon'],
            "city":city_obj['city'],
            "country":city_obj['country'],
            "description":"Ligh pollution report at [" + str(city_obj['lat']) +  "," + str(city_obj['lon']) + "]",
            "severity":severity
        }
        data.append(data_obj)
        
    response = requests.post('http://localhost:8080/import_reports', json=data)
    print(response.content)    

