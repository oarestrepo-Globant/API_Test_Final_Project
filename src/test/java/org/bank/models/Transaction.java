package org.bank.models;

public class Transaction {
    private int id;
    private String name;
    private String lastName;
    private int accountNumber;
    private double amount;
    private String transactionType;
    private String email;
    private boolean active;
    private String country;
    private String telephone;


    /**
     * Constructor Method
     * which assigns values to the declared attributes.
     *
     * @param name String
     * @param lastName String
     * @param accountNumber int
     * @param amount double
     * @param transactionType String, any of: "withdrawal","payment","invoice" or,"deposit"
     * @param email String
     * @param active boolean
     * @param country String
     * @param telephone String
     *
     * @author oscar.restrepo
     * */
    public Transaction(String name, String lastName, int accountNumber, double amount, String transactionType, String email, boolean active, String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }

    /**
     * Default Constructor Method
     * */
    public Transaction(){};

    /**
     * gets the value of the id attribute
     *
     * @author oscar.restrepo
     * */
    public int getId() {
        return id;
    }

    /**
     * gets the value of the name attribute
     *
     * @author oscar.restrepo
     * */
    public String getName() {
        return name;
    }

    /**
     * gets the value of the lastName attribute
     *
     * @author oscar.restrepo
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * gets the value of the accountNumber attribute
     *
     * @author oscar.restrepo
     * */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * gets the value of the amount attribute
     *
     * @author oscar.restrepo
     * */
    public double getAmount() {
        return amount;
    }

    /**
     * gets the value of the transactionType attribute
     *
     * @author oscar.restrepo
     * */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * gets the value of the email attribute
     *
     * @author oscar.restrepo
     * */
    public String getEmail() {
        return email;
    }

    /**
     * gets the value of the active attribute
     *
     * @author oscar.restrepo
     * */
    public boolean isActive() {
        return active;
    }

    /**
     * gets the value of the country attribute
     *
     * @author oscar.restrepo
     * */
    public String getCountry() {
        return country;
    }

    /**
     * gets the value of the telephone attribute
     *
     * @author oscar.restrepo
     * */
    public String getTelephone() {
        return telephone;
    }

}



