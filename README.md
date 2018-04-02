# TestAssignmentProject2
## startCodeForTesting1


This project contains start code for an exercise given at cphbusiness.dk for the educations:
Original code project: https://github.com/Lars-m/startCodeForTesting1.git 

## Assignment Tasks

 - Explain the necessary steps you did to make the code testable, and some of the patterns involved in this step 
 - Execute your test cases 
 - Explain basically about JUnit, Hamcrest, Mockito and Jacoco, and what problems they solve for testers 
 - Demonstrate how you used Mockito to mock away external Dependencies 
 - Demonstrate how/where you did state-based testing and how/where you did behavior based testing 
 - Explain about Coverage Criterias, using the results presented by running Jacoco (or a similar tool) against you final test code. 
 - Explain/demonstrate what was required to make this project use, JUnit (Hamcrest), Mockito and Jacoco 

## Assignment Solution

 
##### Explain the necessary steps you did to make the code testable, and some of the patterns involved in this step 
 
###### Refactoring
 
General steps to refactor the code 
 
The code was untestable because hidden dependencies.
The refactoring separated out dependencies.
The original code violated many rules for writing testable code.
Refactor the code using polymorphism and the Factory Method Pattern helped to make the code more testable. 
 
###### Refactor DateFormatter

*Before*
 
In the original code a new Date object was instantiated inside the method which violated single responsibility pattern.
It didn't make use of Polymorphism and it had a static method.


*The basic issue with static methods is they are procedural code. It not easy unit-test procedural code. 
Unit-testing assumes that we can instantiate a piece of the application in isolation and dependencies can be mocked or replaced with stubs.
This is hard or impossible when methods are static. For writing testable code static methods should be avoided.*
 
*After*

 A interface IDateFormatter has a non static method that inject a Date instance.
The DateFromatter implements the interface IDateFormatter.

###### Refactor JokeFetcher

By using polymorphism for JokeFetcher
By using polymorphism for JokeFetcher and EduJoke, Moma, Chuck, and Tambal implement the interface IJokeFetcher.
Each IJokeFetcher implementation contains the different logic for fetching the joke from the API.


FetcherFactory implements IFetcherFactory interface.

The difference IJokeFetcher are instantiated with FetcherFactory that uses the Factory Method Pattern.

The Factory Method Pattern is used because logic is required for instancing the IJokeFetcher types. This pattern implements this logic and returns the right types,

##### Execute your test cases 

 [![https://gyazo.com/f95872b3c7c7d5d1b19a523bd5183a0a](https://i.gyazo.com/f95872b3c7c7d5d1b19a523bd5183a0a.png)](https://gyazo.com/f95872b3c7c7d5d1b19a523bd5183a0a)
 
 
##### Explain basically about JUnit, Hamcrest, Mockito and Jacoco, and what problems they solve for testers 
 
###### JUnit
*Is:*
 
JUnit is a unit testing framework for Java programming language. 
JUnit is a simple, open source framework to write and run repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks. JUnit features include:

Assertions for testing expected results
Test fixtures for sharing common test data
Test runners for running tests
JUnit was originally written by Erich Gamma and Kent Beck. [source](https://junit.org/junit4/faq.html#overview_1)
 

 
*Solves problem for testers:*
 
It is a tool for writing automated test against code.
It is also a tool used in TDD. It aids the programmer to write the test against his own code. So coding and testing can be done by the same developer.
There is huge cost benefits in discovering bugs early in the development of code.
 
###### Hamcrest
*Is:*
  
Hamcrest. Matchers that can be combined to create flexible expressions of intent. Assertions can be stated declaratively.
  
*Solves problem for testers:*
  
Extends the JUnit library with more flexibility and more readable tests. Readable rest can act as part of the documentation for developers.
  
  
###### Mockito
*Is:*
  
Mockito is the most popular mocking framework for Java, but exists for other languages. 
It lets testers write (unit) tests with a clean & simple API. 
 
*Solves problem for testers:*

The framework aids the Junit tests in mocking away dependencies so objects can be tested in isolation.  
It has feature of Behavior test with *verify* by asking questions about interactions after execution. 
  
###### Jacoco
*Is:*
 
JaCoCo – a code coverage reports generator for Java projects.
 
*Solves problem for testers:*
  
It helps the tester to get fast automated generated code coverage analyzes/metrics. 
I saves time for testers rather than calculated it manually.
It is a tool to message code coverage and confidence in he test.

  
##### Demonstrate how you used Mockito to mock away external Dependencies 

I use Mockito to mock away the external dependency date in DateFormatterTest. 
My having a mock returning a fixed date the DateFormatter class can be tested in isolation.


In IFetcherFactoryTest I mock away the FetcherFactory so it returns stubbed Jokes.
In this way we can test the JokeFetchers behavior in isolation. 

Below the setup of mocks for testing the JokeFetchers and FetcherFactory.

[![https://gyazo.com/a3ec5006e2bceb17103ad8b1fd79eec7](https://i.gyazo.com/a3ec5006e2bceb17103ad8b1fd79eec7.png)](https://gyazo.com/a3ec5006e2bceb17103ad8b1fd79eec7)


##### Demonstrate how/where you did state-based testing and how/where you did behavior based testing

State based testing is when you exercise one or many methods of an object and then assert the expected state of the object.
DateFormatterTest does statebased testing by checking how the time(state) change depending on different input.

[![https://gyazo.com/70975fa71be4bcc1df74ae4b1dcea053](https://i.gyazo.com/70975fa71be4bcc1df74ae4b1dcea053.png)](https://gyazo.com/70975fa71be4bcc1df74ae4b1dcea053)

Behavior based testing is when you expect specific interactions to occur between objects when certain methods are executed. 
Utilization of Mockitos method verify the test verify that expected interaction between objects of a system. 
Behavior based testing is about specifying how the system should behave rather than specifying the expected result of running the system.

Below is an example of my test where we verify a certain behavior, in this case that the method *getFormattedDate* is called exactly one time *times(1)*.

``` 
verify(dateFormatterMock,times(1)).getFormattedDate(anyString(),anyObject());// Verify with wanted number of invocations 
```

[![https://gyazo.com/ab69ffc4790e8e5f113b692a686aca30](https://i.gyazo.com/ab69ffc4790e8e5f113b692a686aca30.png)](https://gyazo.com/ab69ffc4790e8e5f113b692a686aca30)


##### Explain about Coverage Criterias, using the results presented by running JaCoCo (or a similar tool) against you final test code. 

Code coverage is a way of ensuring that your tests are actually testing your code. 
When you run your tests you are presumably checking that you are getting the expected results. 
Code coverage will tell you how much of your code you exercised by running the test. 
The higher code coverage the more confidence we can have in the test. As a best practice 80% code coverage is aimed for.

The picture below shows the result from running the automated code coverage tool JaCoCo. I haven't implemented 80% code coverage because I have focused on the learning aspects in this project.

[![https://gyazo.com/ae3a1bd4822897f49c7661391566ecb3](https://i.gyazo.com/ae3a1bd4822897f49c7661391566ecb3.png)](https://gyazo.com/ae3a1bd4822897f49c7661391566ecb3)


##### Explain/demonstrate what was required to make this project use, JUnit (Hamcrest), Mockito and JaCoCo  

The first step was to make the code testable following the SOLID principles in particular Single responsibility, polymorphism and no hidden dependencies.
The code needed to be refactored as described above to be able to test it with JUnit.
So getting rid of hidden dependencies was the first step in doing that.

When the code was refactored the code were ready to test.

Test and verify behavior using Mockito were made easier by refactoring the code to Factory Method Pattern in IFetcherFactory interface implemented in FetcherFactory.

Becuase I used JUnit 5 and the IDE Intellij both Hamcrest anf JaCoCo was build into the project and could be used on the fly.

Hamcrest is used to make the test more readable and JaCoCo to see ho much code coverage the test has.




