movie-info-service
==============

The movie-info-service is currently one of three microservices in the "Movie Rating Microservices" project. The current services are:
- movie-catalog-service
- movie-info-service
- ratings-data-service

This REST service accepts a movieId at 
```
localhost:8082/movies/{movieId}
```
and returns a the movie name and description associated with that movieId.

Technologies
------------

- Java 8
- Maven
- Spring Boot
- Spring Cloud
- Eureka

How To Run
----------

Requirements 
- [Java 8](https://java.com/en/download/help/download_options.xml)
- [Maven](https://maven.apache.org/install.html)

Run
```
mvn spring-boot:run
```
at the project root to start the microservice.

Default Ports
-------------------
- **movie-catalog-service**: 8081
- **movie-info-service**: 8082
- **ratings-data-service**: 8083
- **discovery-server**: 8761

Remarks on the Code
-------------------

The microservices are: 
- **movie-catalog-service** returns a list of all the movies that a user has reviewed, the movie's rating, and the movie description when provided a user ID. 
- **movie-info-service** returns the name and description of a particular movie when provided the movie ID.
- **ratings-data-service** returns a list of all movie IDs and ratings from a particular user when provided a user ID.
- **discovery-server** is the Eureka server for service discovery.

This is a read only API, and all data is stubbed using json files in the movie-info-service and ratings-data-service.
There are currently three movie reviewers you can obtain results for, with userId's of 1, 2, and 3.

The origin of this project was a [Java Brains tutorial on Spring Boot Microservices](https://www.youtube.com/watch?v=y8IQb4ofjDo ). I have since expanded on the original project, 
using these microservices to get familiar with and implement new technologies while learning about them.