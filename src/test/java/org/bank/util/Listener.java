package org.bank.util;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;

/**
 * Listener class to configurate all the listeners.
 *
 * @author oscar.restrepo*/
public class Listener implements ITestListener {
    public Logger log = Logger.getLogger(Listener.class);

    /**
     * log info when the test starts.
     *
     * @author oscar.restrepo*/
    @Override
    public void onTestStart(ITestResult result) {
        log.info("TEST: " + result.getName() + " [  STARTED  ]");
    }

    /**
     * shows info when the test is successful.
     *
     * @author oscar.restrepo*/
    @Override
    public void onTestSuccess(ITestResult result) {
       log.info("TEST: " + result.getName() + " [  PASSED  ]\n");
    }

    /**
     * shows info when test fails.
     *
     * @author oscar.restrepo*/
    @Override
    public void onTestFailure(ITestResult result) {
        log.info("TEST: " + result.getName() + "[  FAILED  ]\n");
    }
}
