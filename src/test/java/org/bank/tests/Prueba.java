package org.bank.tests;

import org.bank.util.tests.BaseApiTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasItem;

public class Prueba extends BaseApiTest {
    /**
     * validates that there is no data in the endpoint /transactions.
     */
   /* @Test
    public void deleteDataEndpoint() {
        log.info("Endpoint is empty");
        Assert.assertTrue( deleteAllTransactions(), "Endpoint is not empty");
        log.info("Check status code 200 from get request");
          checkStatusCode(response, 200);
    }*/

    /**
     * validates that there are not duplicate email accounts in the transactions.
     */
   /* @Test
    public void verifyThereIsNotEmailDuplicated() {
        log.info("There is no duplicate email account in the transactions");
        Assert.assertFalse(areDuplicateEmailsAccount(), "Theres is duplicate email account");
        log.info("Check status code 200 from get request");
         checkStatusCode(response, 200);
    }*/

    /**
     * validate an update from existing Account Number.
     */
    @Test
    public void updateExistingAccountNumber() {
        // dataprovider
        log.info("Update existing account number");
        checkStatusCode(response, 200);super.updateExistingAccountNumber(1, "2289");

        createRandomTransaction();
        checkStatusCode(response, 201);
    }
}
 /*// DELETE USER

        // GIVEN
        Response response1 = given().
                contentType(JSON).

       // WHEN
        when().
                delete("https://637ba6b272f3ce38ea9192b4.mockapi.io/transactions/2");

        // THEN
        response1.then().
                    assertThat().
                statusCode(200);
*/
