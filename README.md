# Mecbox
Mecbox is an open-source application generator used to develop quickly modern web applications using the Spring Framework.

## What you’ll need

In order to build the mecbox application, your environment should fulfill the following requirements:

* A favorite text editor or IDE
* JDK 1.8 or later
* Maven 3.0+
* Mysql Server

## What you’ll build

You’ll build a template web application that will provide out of the box :
* Authentication & authorization;
* Responsive graphical interface (html, css, js):
  * Tables with enhanced interaction controls (search, export, sorting, etc.);
  * Charts;
* Server side components:
  * CRUD (insert, delete, update);
  * Search filters;
  
## How to build
Download and unzip the source code in your workspace `MECBOX_PATH`.
Before building the application you must create a MySQL database. From the command line go to MySQL installation directory `MYSQL_PATH`:
```
cd MYSQL_PATH\bin;
mysql -u db_username -p
mysql> create database mecbox;
```
Then create the tables needed to run the application, using the script `mecbox.sql` stored in the `MECBOX_PATH/sql` folder:
```
mysql> use mecbox;
mysql> source mecbox.sql
```

The script will populate the `USER/ROLES` tables with two users:
```
Username: admin@mecbox.it
Password: mecbox
Role: ADMIN

Username: guest@mecbox.it
Password: mecbox
Role: GUEST
```

From your IDE select and open the unzipped maven project.
As a first step check the content of the application.properties file, located in the path `Other Sources > src/main/resources`:

```
spring.datasource.url = jdbc:mysql://localhost:3306/mecbox?useSSL=false
spring.datasource.username = db_username
spring.datasource.password = db_password
```
Now you can perform your first build of the application.
If the build process ends successfully, you are ready to run the application. 
The application is built using the open source framework Spring Boot, which generates an 
executable jar (that can be run from the command line). Spring Boot creates a stand-alone Spring 
based Applications, with an embedded Tomcat, that you can "just run".
```
java –jar  mecbox-1.0.jar
```
In the docs folder you will find a complete userguide with useful information that will help you to understand mecbox project.

## License
Mecbox is EUPL-licensed
