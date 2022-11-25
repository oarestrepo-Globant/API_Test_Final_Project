package org.bank.util.tests;


import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.bank.models.Transaction;
import org.bank.util.RestAssuredUtil;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base test for API tests.
 */
public class BaseApiTest extends RestAssuredUtil{
    protected Response response = null;
    //protected JsonPath jasonPath = null;
    protected static List<Transaction> allTransactions;
    public Logger log = Logger.getLogger(BaseApiTest.class);

    /**
     * initializes the initial setUp.
     * Define baseURI, contentType("application/json") and get all transactions.
     *
     * */
    @BeforeClass
    public void setup() {
        //Test Setup
        RestAssuredUtil.setBaseURI(); //Setup Base URI
       // RestAssuredUtil.setBasePath("transactions"); //Setup Base Path
        RestAssuredUtil.setContentType(JSON); //Setup Content Type
        allTransactions = getAllTransactions();
    }

    /**
     * after class resets the baseURL and the basePath.
     **/
    @AfterClass
    public void afterTest() {
        //Reset Values
        RestAssuredUtil.resetBaseURI();
        RestAssuredUtil.resetBasePath();
    }

    /**
     * Verify that the status code returned is equal to the expected status code.
     * @param statusCodeExpected:res
     * */
    public void checkStatusCode(Response res, int statusCodeExpected) {
        Assert.assertEquals(res.getStatusCode(), statusCodeExpected, "Status Check Failed!");
    }

    /**
     * get all transactions, deserialize JSON Array to List and return that list
     * @author oscar.restrepo
     * */
    public  List<Transaction> getAllTransactions(){
       /* RestAssured.baseURI =  "https://637ba6b272f3ce38ea9192b4.mockapi.io/";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();*/

        response = getResponse();
        JsonPath jsonPathEvaluator = response.jsonPath();

        List<Transaction> transactions = jsonPathEvaluator.getList("transactions", Transaction.class);

        this.allTransactions = transactions;
        return allTransactions;
    }

    /**
     * evaluates whether the endpoint has data and return true if it has data, otherwise return false.
     * @author oscar.restrepo
     * */
    public boolean isEndpointEmpty(){

        return allTransactions.size() == 0;
    }

    /**
     * delete transaction.
     *
     * @param id:int
     * @author oscar.restrepo
     * */
    public void deleteTransaction(int id){
        Response response1 =
                /*given().
                contentType(JSON).

                        when().
                delete("https://637ba6b272f3ce38ea9192b4.mockapi.io/transactions/2");*/
           deleteResponse(baseURI+id);

        response1.then().
                assertThat().
                statusCode(200);
    }

    /**
     * return true if there is data in the path /transactions, if it finds data it deletes it.
     * Otherwise, return false.
     *
     * @author oscar.restrepo
     * */
    public boolean deleteAllTransactions(){

        if(allTransactions.size() != 0){
            for (Transaction transaction:allTransactions) {
                deleteTransaction(transaction.getId());
            }
        }

        response = deleteResponse(baseURI);
        allTransactions = getAllTransactions();
        return allTransactions.size() == 0;
    }

    /**
     * Make the GET request, asserting that there are not duplicate email accounts
     *
     * @return true if there are duplicate email accounts, otherwise return false.
     *
     * @author oscar.restrepo
     */
    public boolean areDuplicateEmailsAccount() {
       List<String> emailsAccounts = new ArrayList<>();
       allTransactions = getAllTransactions();

        for (Transaction transaction:allTransactions) {
           if(!emailsAccounts.contains(transaction.getEmail())){
               emailsAccounts.add(transaction.getEmail());
           }
        }

        response = getResponse(baseURI);
        return allTransactions.size() != emailsAccounts.size();
    }

    /**
     * Make the GET request, asserting that there are not duplicate email accounts
     * @param id:int
     * @param newAccountNumber:String
     *
     * @author oscar.restrepo
     */
    public void updateExistingAccountNumber(int id, String newAccountNumber) {
        Map<String, String> transaction = new HashMap<>();
        transaction.put("accountNumber", newAccountNumber);

        response =  putResponse(baseURI+id,transaction);
       ;
    }

    /**
     * creates a new transaction and makes a post to the endpoint.
     *
     * @author oscar.restrepo
     */
    public void createRandomTransaction(){
        Map<String, String> transaction = new HashMap<>();
       response = postResponse(baseURI, transaction);
    }
}
