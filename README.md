# API Automation Final Project
The test is designed in a single test class called "BankTransacionTest" with 4 different test cases.
 - deleteDataEndpoint
 - initializePojo
 - verifyThereIsNotEmailDuplicated
 - updateExistingAccountNumberTest
 <br>
 
 ## STEPS
 The installation is very simple, just follow these instructions
 - Clone the repo in local directory
 - To install dependencies type the following command in the terminal: mvn clean install -DskipTests
 - You can run the test by executing the Suite.xml file or the BankTransactionsTest.class file.
 <br>
 
 ## CONSIDERATIONS
### Test deleteDataEndpoint
- Validates that there is no data in the endpoint /transactions. If it has data then delete it.
- If the endpoint has too many records then it will throw a 429 error. For best performance, before starting the test, make sure there are less than 30 records in the endpoint.
### Test initializePojo
- Validates that the POJO has been initialized with Transactions that have different emails from each other.
- The javafaker dependency is used to generate 10 different transactions
### Test verifyThereIsNotEmailDuplicated
- Validates that there are not duplicate email accounts in the endpoint transactions.
### Test updateExistingAccountNumberTest
- validates the update of a transaction. This update is the change of the account number.
- The information needed to run the test is defined by @DataProvider.  By default the program will always update the transaction with id = 1. 
- The one in charge of generating the random account number is javaFaker. 
- If you want to modify a different element to the one identified with id=1 then you must look for the @DataProvdider found in the "BankTransactionsTest" file.
