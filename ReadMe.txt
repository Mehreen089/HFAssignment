- Test assignment uses java, testing and maven
- It is modified in page object model way
- All pages have separate classes for its elements and functions
- WebTest class contains 3 test methods for signup, login and checkout
- Webdriver factory is implemented  , to use any required driver efficiently
- Log file is maintained to keep track of failures and can be found in resources folder
- Screesnshots are captured on failure and are stored in resource> screesnshots folder
- Config.properties file can be found in resources folder in which any static parameter can be added to change it in future one can edit that file 
- methods-test-testng.xml file is a suite that runs WebTest test cases, by adding parameter in it test cases can be executed in parallel
- Reports are saved in test-output folders for each suite separate folder is maintained automatically by testing
-	RestApiTest class contains test cases for rest API Assignment
-	Following additional jars are used for restApi test
•	org.codehaus.groovy
•	io.rest-assured
•	org.apache.httpcomponents
•	javax.xml.bind
•	com.googlecode.json-simple
-	Following jars are used to generate random and unique but fake data for new users
•	com.github.javafake
•	com.github.mifmif
-	Post test case is handled and is commented in RestApiTest class but cannot be tested because not originally implemented.
