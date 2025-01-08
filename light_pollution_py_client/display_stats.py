import json
from matplotlib import pyplot as plt
import pandas as pd
import requests

response = requests.get('http://localhost:8080/get_stats', json=[])
respL = json.loads(response.text)
print(respL)

all = True

dataMap = respL['allMap']

if all == False:
    dataMap = respL['fixedMap']

data = []
for country in dataMap:
    data.append({"country":country, "val":dataMap[country]})  


data.sort(key=lambda x: x['val'], reverse=False)    

xs = []
ys = []
for dataObj in data:
    xs.append(dataObj['country'])
    ys.append(dataObj['val'])

plt.bar(xs, ys)
plt.title('Reports per country')
plt.xlabel('country')
plt.ylabel('Count')
plt.show()
