# startCodeForTesting1
This project contains start code for an exercise given at cphbusiness.dk for the educations:
* AP degree in Computer Science
* Top-up Bachelor's degree in Software Development
# TestAssignmentProject2



 - Explain the necessary steps you did to make the code testable, and some of the patterns involved in this step 
 - Execute your test cases 
 - Explain basically about JUnit, Hamcrest, Mockito and Jacoco, and what problems they solve for testers 
 - Demonstrate how you used Mockito to mock away external Dependencies 
 - Demonstrate how/where you did state-based testing and how/where you did behavior based testing 
 - Explain about Coverage Criterias, using the results presented by running Jacoco (or a similar tool) against you final test code. 
 - Explain/demonstrate what was required to make this project use, JUnit (Hamcrest), Mockito and Jacoco 
 
##### Explain the necessary steps you did to make the code testable, and some of the patterns involved in this step 
 
 Refactoring
 
 
 1) Step
 
###### Refactor DateFormatter

*Before*
 
In the original code a new Date object was instantiated inside the method which violated single responsibility pattern.
 It didn't make use of Polymorphism and it ha a static method
 
*After*

 A interface IDateFormatter has a non static method that inject a Date instance.
The DateFromatter implements the interface.

###### Refactor JokeFetcher
By using polymorphism for JokeFetcher and EduJoke, Moma, Chuck, and Tambal implement the interface IJokeFetcher.
Each IJokeFetcher implemetation contains the different logic for fetching the joke from the API.


FetcherFactory implements IFetcherFactory interface.

The difference IJokeFetcher are instantiated with FetcherFactory that uses the Factory Method Pattern.

The Factory Method Pattern is used because logic is required for instancing the IJokeFetcher types. This pattern implements this logic and returns the right types,

 
 
##### Execute your test cases 
 
##### Explain basically about JUnit, Hamcrest, Mockito and Jacoco, and what problems they solve for testers 
 
###### JUnit
 *Is:*
 
 JUnit is a unit testing framework for Java programming language. It plays a crucial role test-driven development, and is a family of unit testing frameworks collectively known as xUnit. [source](https://www.tutorialspoint.com/junit/junit_overview.htm)
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
  
  Hamcrest. Matchers that can be combined to create flexible expressions of intent.
  
  *Solves problem for testers:*
  
  Extends the JUnit library with more flexibility and more readable tests.
  
  
###### Mockito
  *Is:*
  *Solves problem for testers:*
  
###### Jacoco
  *Is:*
 
  *Solves problem for testers:*
  
##### Demonstrate how you used Mockito to mock away external Dependencies 


##### Demonstrate how/where you did state-based testing and how/where you did behavior based testing

##### Explain about Coverage Criterias, using the results presented by running Jacoco (or a similar tool) against you final test code. 

##### Explain/demonstrate what was required to make this project use, JUnit (Hamcrest), Mockito and Jacoco  