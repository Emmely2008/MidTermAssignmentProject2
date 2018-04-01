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

The difference IJokeFetcher are instantiated with a Factory Method Pattern.

I IFetcherFactory is th interface an  FetcherFactory implements this.

The Factory Method Pattern is used because logic is required for instancing the IJokeFetcher types. This pattern implements this logic and returns the right types,

 
 
##### Execute your test cases 
 
##### Explain basically about JUnit, Hamcrest, Mockito and Jacoco, and what problems they solve for testers 
 
###### JUnit
 *Is:*
 Is a unit test framework for Java.
 
 *Solves problem for testers:*
 
###### Hamcrest
  *Is:*
  *Solves problem for testers:*
  
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