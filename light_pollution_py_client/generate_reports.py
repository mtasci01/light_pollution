from pandas import read_csv

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

