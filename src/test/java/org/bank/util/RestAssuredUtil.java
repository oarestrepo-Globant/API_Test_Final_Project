package org.bank.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.bank.models.Transaction;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;

/**
 * class to define rest assured methods.
 *
 * @author oscar.restrepo
 * */
public class RestAssuredUtil {

    /**
     * sets base URL.
     *
     * @author oscar.restrepo
     * */
    public static void setBaseURI() {
        RestAssured.baseURI = "https://637ba6b272f3ce38ea9192b4.mockapi.io/transactions/";
    }

    /**
     * reset Base URI.
     *
     * @author oscar.restrepo
     * */
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /**
     * reset base path.
     *
     * @author oscar.restrepo
     * */
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    /**
     * sets ContentType.
     *
     * @param Type:ContentType
     * @author oscar.restrepo
     * */
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    /**
     * return get response.
     *
     * @author oscar.restrepo
     * */
    public static Response getResponse() {
        return given().get();
    }

    /**
     * return delete response.
     *
     * @param path:String
     * @author oscar.restrepo
     * */
    public static Response deleteResponse(String path) {
        return given().delete(path);
    }

    /**
    * return put response.
     *
     * @param path:String
     * @param transaction:Map
     * @author oscar.restrepo
    * */
    public static Response putResponse(String path, Map transaction) {
        return given().contentType(JSON).body(transaction).put(path);
    }

    /**
     * return post response.
     *
     * @param path:String
     * @param transaction:Map
     * @author oscar.restrepo
     * */
    public static Response postResponse(String path, Transaction transaction) {
        return given().contentType(JSON).body(transaction).post(path);
    }

}