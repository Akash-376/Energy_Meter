# Energy_Meter
<br>

<img src="https://user-images.githubusercontent.com/112763866/231248151-369d5f21-f8d8-4859-b3eb-555e34a09c80.jpg" alt="Image Description" width="100%" height="350">


# Description
Energy meters send incremental values every minute, and the task at hand is to calculate hourly energy consumption by finding the differential value between consecutive minutes. The minute incremental energy meter readings are stored in a table where column-1 represents the timestamp (yyyy-MM-dd HH:MM:SS), column-2 stores minute values (min), and column-3 is designated for hourly values (hour). Three essential methods are implemented to manage and analyze the energy data.

## Sample Table
![Energy meter data](https://github.com/Akash-376/Energy_Meter/assets/112763866/c897676d-eff2-4402-ae41-f0910c36abc8)

## Prerequisites
Before you begin, ensure you have met the following requirements:

- Java: You need Java 8 or higher installed on your system.
- MySQL: Make sure you have a MySQL database instance set up.
- Maven: You'll need Maven as the build tool.

## Frameworks_and_Libraries_Used
- Spring Boot: A powerful framework for building Java applications.
- Swagger: Used for API documentation.
- Hibernate: Object-relational mapping library.
- Lombok: For reducing boilerplate code.

## Installation
1. Clone the repository:
```
git clone https://github.com/Akash-376/Energy_Meter.git
```
2. Navigate to the project directory:
   In which POM.xml is visible
```
cd Energy_Meter
```
3. Build the project using Maven:
```
mvn clean install
```

## Configuration
1. Create the database named 'energy_meter' using MySQL Workbench
2. Open application.properties in the src/main/resources directory.
3. Configure your database settings:
```
spring.datasource.url=jdbc:mysql://localhost:3306/energy_meter
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
```
Replace username and password with yours.

## Running the Application
1. Run the application using Maven:
```
mvn spring-boot:run
```
2. The application should now be running on the specified port (default is 8080).

## API Endpoints
Swagger documentation is available at http://localhost:8088/swagger-ui.html. You can use it to explore and test the API endpoints.

## Usage
### To store eneergy meter progressive values
Send a POST request to:
```
http://localhost:8080/insert/{timeStamp}/{perMinReading}
```

### Calculate hourly Energy consumption
Send a GET request to:
```
http://localhost:8080/fetchHourlyConsumption
```

### To fetch Table values
Send a GET request to:
```
http://localhost:8080/fetchTableValues
```

