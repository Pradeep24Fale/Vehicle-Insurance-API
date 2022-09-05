# Database setup
1. install MySQL 
2. After installation login to MySql using username:root, password:password (username and password is mentioned in application.properties file)
3. After successful login to MySql, create schema with name "insuranceschema" (schema name is mentioned in application.properties file)


# Vehicle-Insurance-API

1. Open CMD and change directory to Vehicle-Insurance-API folder
2. mvn clean install
3. mvn exec:java -Dexec.mainClass=com.vehicle.insuarance.VehicleInsurance.VehicleInsuranceApplication // this will start the application on localhost:8091
4.After running, as data JPA is used in the application, it will ensure all the tables are created.
And import.sql file will take care of initial data in the table.
5.For payment some valid credit card details to verify payment functionality are below:
Account Number:100002,Balance:50000 ,Credit Card Number:10012021, cvv:004

