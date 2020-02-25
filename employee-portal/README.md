# employee-portal
Employee Portal for registering new employees and displays the list of available employees.
It has search option to search the employees from the list.
Gradle, Java 8 and Angular 9 are used for developing the application.

## Technologies
	Front End: Angular 9, SASS/SCSS, Bootstrap, Typescript, Jasmine, Karma, Protractor.
	Back End: Java 8, Spring Boot, Rest API, Swagger, Junit, Mockito.
	
## Getting started

Build:
```
./gradlew build
```
Run the server:

```
java -jar build/libs/emp-portal-0.0.1-SNAPSHOT.jar 
```
Navigate to `http://localhost:8080`

## Development

```
Start the Spring Boot Server on http://localhost:8080
./gradlew bootRun 
```
Start the Angular development server on http://localhost:4200 .
./gradlew npm_start
or
cd employee-portal-ui && ng serve
```

## Testing

Running unit test cases:
### Back end with Junit and Mockito
```
./gradlew test
```
### Front end with Jasmine and Karma.
```
ng test
```
### End to end testing for front end module with protractor .
```
ng test
```
### Swagger UI
```
Once the server is up and running you an see the swagger ui on http://localhost:8080/swagger-ui.html#/
```
