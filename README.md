### The Test automation framework(TAF) for UI automation of check24.de


##### Pre-requisite:
 - **Java** as Programming language.
 - **TestNG** as Base Testing framework
 - **Selenium** for web driver
 - **Log4j** for Logging feature with spring class dependency injection
 - **Maven** as Build tool installed
 - **Page object with layered** architecture
 - Used browser version: Chrome v76.0 and Firefox v68.0.
 - Browser drivers are available in src/main/resources directory.
 
 
##### Automated Test cases:
 1.	Verify user is able to register successfully
 2.	Verify user is able to search travel plan successfully with at least one search result
 3.	Verify user is able to login successfully with valid credentials 
 
 
##### Steps to execute:
1. Clone the code.
2. Import the code into IDE for better visibility. (preferably, Intellij IDEA with maven auto-import enabled)
4. Run with “test_suite.xml” file using following command, It will generate the log file named “test-run.log” file in “result” folder. 

    `mvn clean test -Dsurefire.suiteXmlFiles=test_suite.xml`

`NOTE: if you want to run in firefox browser change the parameter in test_suite.xml file.`

`

