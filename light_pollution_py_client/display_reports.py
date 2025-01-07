import json
import plotly.express as px
import pandas as pd
import requests


response = requests.get('http://localhost:8080/get_all_reports', json=[])

respL = json.loads(response.text)
print(len(respL))
data = []
for o in respL:
    data.append({
        "lat":o['lat'],
        "lon":o['lon']
    })

fig = px.scatter_mapbox(data, 
                        lat="lat", 
                        lon="lon", 
                        
                        zoom=1, 
                        height=800,
                        width=800)
fig.update_layout(mapbox_style="open-street-map")
fig.update_layout(margin={"r":0,"t":0,"l":0,"b":0})
fig.show()