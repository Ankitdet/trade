# trade "OHLC" analytic server.

## General info
The project is "OHLC" analytic server.
	
## Technologies
Project is created with:
- Maven
- Java 8 

## Setup
- Clone this repo in your local machine.
- Import this project, please open eclipse editor and import as a 'Existing Maven Project'.
- Open cmd or shell then goto project directory.
- Type 'mvn clean install'. if you facing some problem then clear .m2 directory andd try.
- Right click on project and run as 'Java Application' -> MainClass.java 
* It will show you 'Add your request in JSON: ' then add request {"event": "subscribe", "symbol": "XXBTZUSD", "interval": 15}.
  for e.g : Add your request in JSON: 
           {"event": "subscribe", "symbol": "XXBTZUSD", "interval": 15}         
- Press Enter
- The bar chart data is write into 'barChart.json' file.
