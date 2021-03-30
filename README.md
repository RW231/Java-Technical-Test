# Dress Searcher Service

Java Technical Test.

This project uses the Spring Boot Framework, Maven and Java 11.

## Running the Application

To run the application, run:
```
mvnw spring-boot:run
```
This will start the application on localhost:8080.

Send a HTTP GET request to `http://localhost:8080/dresses/reduced` to return an array of dresses 
with price reductions, in a highest reduction first order, from the John Lewis product API. Add the 
query parameter `labelType` with a value of `ShowWasNow`, `ShowWasThenNow` or `ShowPercDiscount` 
to change the priceLabel format.

By default, this application will fetch the dress product data from the John Lewis API; however, 
a JSON file can be used as the datasource instead. To use the JSON file, set the `spring.profiles.active`
property in resources/application.properties to `jsonFile`.

## Tests
I created this application in a true TTD style. i.e. tests were written first, before the
implementation. Tests, therefore, exist for all the requirements in the assignment brief.

To run the tests, run:
```
mvnw verify
```

Unit test are named following
the [Roy Osherove standard](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html):
`UnitOfWork_StateUnderTest_ExpectedBehavior`

[Object Methods](https://martinfowler.com/bliki/ObjectMother.html) are used to create example
objects for testing. These classes are grouped in the `com.rosswildman.dresssearcherservice.mother`
test package.
