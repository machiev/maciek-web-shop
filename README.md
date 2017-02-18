# Simple Shop Skeleton

## Requirements 
 - JDK 8
 - Maven 3.2.3 or higher
 - WildFly 10.1.0
 - MySQL 5.1 or higher
 
## Building
 - to create war archive (maciek-web-shop.war):  
 `mvn clean package`

## Database preparation
 1. go to maciek-web-shop/db/ directory
 2. to create database and DB user invoke script (provide MySQL root password when prompted):  
 `./create_db.sh`  
 `shopdb` schema will be created with user: `shopdb` and password: `shopdb`  
 3. to create and fill tables:  
 `mysql -u"shopdb" -p"shopdb" -h"localhost" shopdb < create_schema.sql`
  
## Deploying
  1. start WildFly server, e.g.:  
  `./standalone.sh`
  2. create data source for DB connection with JNDI name: `java:jboss/datasources/mnshopDatabase`  
  provide correct URL, e.g.: jdbc:mysql://localhost/shopdb with user: `shopdb` and password: `shopdb`
  ### Deploy using CLI  
   - run `jboss-cli` command line:  
  [standalone@localhost:9990 /] deploy <path to build's target>/maciek-web-shop.war  
  ### Deploy using Maven  
   - run  
  `mvn wildfly:deploy`

## Web Application Access
Application is available under:  
[localhost:8080/maciek-web-shop](localhost:8080/maciek-web-shop)
