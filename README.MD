# Credit Limit
This is a *Proof of Concept* (**POC**) project using *Spring* and *Vaadin-crudui* in Portuguese to edit basic Client information on Web.

## Description
This application contains a simple grid with form to execute *CRUD* actions on Client entity.

All the fields are required and captions/descriptions/messages were written in Brazilian Portuguese.

The Client entity contains information such as 
  * Name
  * Credit Limit - In R$ (Brazilian real)
  * Financial Risk - Type *A, B or C*
  * Address
  * Interest rate (%) 

## Application Information
The language used for this **POC** is Java. To help in creating this **POC** some frameworks were used like: Spring Boot, Vaadin and the Vaadin-crudui plugin.

With *Vaading-crudui* plugin was possible to create a intuitive grid on web without any *HTML* code. This not means this approach is recommended, but the goal here is to check this functionallity and see how it works.

The database is the H2-database, a in-memory database which everytime you finish your application it will shutdown as well with all your data. This database were chosen to facilitate running the application without any installments of any database. Using Spring JPA it is possible to choose a production database such Oracle, PostgreSQL or MySQL, just changing properties file configuration and everything will continue working like a charm ;) .

To check the data inserted into the H2-database you just need to access it on browser on http://localhost:8080/h2-console/ and pressing ok.

## How to run the application
1. You first need to have *Java SDK 8* installed on your machine.
1. Clone this github repository e unzip it.
1. Go to folder where the project were unzip and run the following command on your machine's terminal
    ``` bash
    #LINUX
    ./mvnw package
    ```
    ``` bash
    #WINDOWS
    .\mvnw.cmd package
    ```
1. After running the maven package command, the folder *target/* will be created. Now it is possible to run the application just executing the *java -jar* command as stated below
    ``` bash
    java -jar target\limite-credito-0.0.1-SNAPSHOT.jar
    ```
1. Done! Just access on your local browser the address: http://localhost:8080/ as test-it.


