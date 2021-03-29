# Dress Searcher Project

Java Technical test

This is a multi-module Maven project with two modules. The Dress Searcher Service, a small RESTful
webservice for finding dresses with price reductions. The Dress Searcher Client, a simple
application which uses the REST API.

I am using the Spring Boot Framework with Java 11.

## Tests

Unit test are naming following
the [Roy Osherove standard](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html):
`UnitOfWork_StateUnderTest_ExpectedBehavior`

[Object Methods](https://martinfowler.com/bliki/ObjectMother.html) are used to create example
objects for testing. These classes are grouped in the `com.rosswildman.dresssearcherservice.mother`
test package.
