# Example of architectural tests

This is an example of architectural tests. The source code is slightly adapted from [https://github.com/withstars/Books-Management-System](https://github.com/withstars/Books-Management-System), a Spring MVC web application used for managing books. The source code is less important in this case; the examples are focused on how to check internal architectural rules.

## What are architectural tests?

Architectural tests are a relatively new type of tests that we can write to automatically check architectural constraints such as:

* classes from a specific package should have names based on specific rules
* classes annotated with a certain annotation should only have final fields
* classes from a specific package should never call classes from another specific package

## Technology

The source code uses Spring MVC and bootstrap. The interface language is Chinese.

For the architectural tests the library [archunit](https://www.archunit.org/) is used

### How to use

* clone this repo
* run `mvn clean compile`
* run `mvn clean package`
* run `mvn clean install`
* to run the app, run `mvn jetty:run` and navigate to [http://localhost:8080](http://localhost:8080)
* to run the architectural tests, run `mvn test`

Some of the tests will be failing on purpose, to demonstrate violations of the architectural rules.

All architectural tests are in the folder `src/test/java/archtests/`.

Play with the code as you want. Have fun!

If you have any questions, please contact [alex.bolboaca@mozaicworks.com](mailto:alex.bolboaca@mozaicworks.com).
