# Tomcat 10.1 Application with Spring Boot

This is a Tomcat 10.1.x sample jsp application that has been "bootified" to show how to convert a jsp application into a spring boot one. It uses the benefits of spring boot's DI framework to translate servlets, configuration, as well as configuration routes for views and servlets. It's meant to show how to easy the transition from older jsp applications to new cloud native apps.

## Deploy to Cloud Foundry

Additionally this app includes a manifest file to help deploy this app in cloud foundry with the correct configuration. 

### Context.xml

```xml
<Resource name="jdbc/test_db" auth="Container"
        factory="com.zaxxer.hikari.HikariJNDIFactory"
        type="javax.sql.DataSource"
        minimumIdle="5" 
        maximumPoolSize="10"
        connectionTimeout="300000"
        dataSourceClassName="org.postgresql.ds.PGSimpleDataSource"
        dataSource.serverName="localhost"
        dataSource.portNumber="5432"
        dataSource.databaseName="test_db"
        dataSource.user="postgres"
        dataSource.password="admin"
        />
```