package org.bank.tests;

import org.bank.util.Listener;
import org.bank.util.tests.BaseApiTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
/**
 * Public class for Bank Transaction Test
 * */

public class BankTransactionsTest extends BaseApiTest {
    /**
     * validates that there is no data in the endpoint /transactions.
     * validate status code is 200
     */
    @Test(priority = 1)
    public void deleteDataEndpoint() {
        log.info("Check status code 200 from GET request");
        assertStatusCode(response, 200);

        log.info("Endpoint is empty");
        Assert.assertTrue( deleteAllTransactions(), "Endpoint is not empty");
    }

    /**
     * validates that the POJO has been initialized with Transactions that have different emails from each other.
     * validate status code is 201
     */
    @Test(priority = 2)
    public void initializePojo(){
        log.info("POST request with 10 random data");
        postTransactions();

        log.info("Check status code 201 from PUT request");
        assertStatusCode(response, 201);
    }

    /**
     * validates that there are not duplicate email accounts in the transactions.
     * validate status code is 200
     */
    @Test(priority = 3)
    public void verifyThereIsNotEmailDuplicated() {
        log.info("There is no duplicate email account in the transactions");
        Assert.assertFalse(areDuplicateEmailsAccount(), "Theres is duplicate email account");

        log.info("Check status code 200 from GET request");
         assertStatusCode(response, 200);
    }

    /**
     * validate an update from existing Account Number.
     * validate status code is 200
     */
    @Test(dataProvider = "idTransaction" , priority = 4)
    public void updateExistingAccountNumberTest(String idTransaction) {
        log.info("Update existing account number");
        super.updateExistingAccountNumber(idTransaction);

        log.info("Check status code 200 from PUT request");
        assertStatusCode(response, 200);
    }
}

