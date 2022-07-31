# FilmQuery Project
 
# Description
  
  This project is a first-step into SQL/JDBS, exception handling through try/catches and exception declarations being integrated into a Java project. The user is presented a menu from which they can access a database for information about a film or films meeting the users submitted search words. Entries that are not compatible with what the program excepts are handled through exception handling that will redirect the program to a method that will allow the user to try a valid entry. 
  
  Use of Object-Relational Mapping and CRUD: This project utilizes Maven and a driver for establishment of a connection to the film database. The R in CRUD stands for "Retrieve". For each table utilized by this program, an entity was created to allow reliable interaction with the film database. 
  
# Technologies Used

Eclipse
Git
Java
JDBC
Maven
Relational Database Management System: MySql
Terminal- ZSH

# What I learned
 
##### Predicates & Functions (LIKE):
Transferring the users dynamic string input for the binding variable was an excellent exercise in syntax and working with bind variables (see PreparedStatement below) and what bind variables represent. 

##### Object Relational Mapping (ORM): 

###### Exception Handling
Exception handling infinite loops occur through "InputMismatchException" unless you reset the scanner with "input.next();".

###### PreparedStatement
PreparedStatements, pre-parsed and compiled by the Database Management System (DBMS) was still an enigma to me prior to beginning this project. Due specifically to writing the code for the "findFilmByKeyword" method, I was able to solidify that the "?" in the SELECT statement represented the users input and the two arguments for setting the value represented which question mark you're referring to in numerical order and the alias used for the data to apply respectively. 