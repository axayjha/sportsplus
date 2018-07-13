# SportsPlus

This is a class project demonstrating the basics of Spring MVC, IoC containers for Java objects
and Apache Maven for build automation. We are using Java Persistence API to manage relational data
connections to H2 database and RESTful web services to bind front-end.

# Prerequisites
* JDK 1.8
* Spring Framework 5+
* Spring Boot 2.0.3
* Maven 4
* Tomcat 8.5

# Getting started

* Fork this project
* Clone and import to your IDE as existing Maven project
* Update your port in application.properties

# Running the project

```
$ java -jar *jar

```

Launch the project at http://localhost:port/

# Feature Highlights


* File Structure

	* Based on maven-webapp archetype, the project file structure is defined as below:
	
	* src/main/java for Java Sources
	* src/main/resources for static configuration files
	* src/test/* for tests
	* src/main/resources/static for static web resources (css, html, img, js)


* Spring MVC

	* Annotation Based Configuration
	* Selective Component Scan
	* Inversion of Control
	* Mock HttpServletResponse & Response for Integration Testing
	* SpringJUnit4ClassRunner for utilizing annotations during testing


* Hibernate

	* ORM Mapping
	* Model Validation
	* Transaction Management
	* Data-access-level pagination
	
	
* Maven

	* Project Object Model (POM) Configuration
	* Platform independent resource & compilation encoding
	* Utilization of springboot-maven-plugin
	* Single line of command (mvn spring-boot:run) to clean, test, build and deploy



* Front-End

	* script.js for Document Object Model (DOM) Templating
	* jQuery for DOM Manipulation
	* Bootstrap for front-end styling and modal popUp actions
	* Namespacing pattern adopted for JavaScript
	
	
* Database Management
	* MySQL
	
	
* Version Control
	* Git
	
	
