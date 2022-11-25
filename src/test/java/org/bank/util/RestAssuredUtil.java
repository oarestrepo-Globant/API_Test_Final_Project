package org.bank.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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

    //Sets Base URI
    /**
     * sets base URL.
     *
     * @author oscar.restrepo
     * */
    public static void setBaseURI() {
        RestAssured.baseURI = "https://637ba6b272f3ce38ea9192b4.mockapi.io/transactions/";
    }

    /**
     * sets base path.
     *
     * @param basePathTerm:String
     * @author osca.restrepo
     * */
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
                //baseURI+basePathTerm;
    }

    /**
     * reset Base URI.
     *
     * @author osca.restrepo
     * */
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /**
     * reset base path.
     *
     * @author osca.restrepo
     * */
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    /**
     * sets ContentType.
     *
     * @param Type:ContentType
     * @author osca.restrepo
     * */
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    /**
     * returns get response by given path.
     *
     * @param path:String
     * @author osca.restrepo
     * */
    public static Response getResponse(String path) {
        return given().get(path);
    }

    /**
     * return get response.
     *
     * @author osca.restrepo
     * */
    public static Response getResponse() {
        return given().get();
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
////////////////////////////////////////////////////////////////////////
    /**
     * return delete response.
     *
     * @param path:String
     * @author osca.restrepo
     * */
    public static Response deleteResponse(String path) {
        return given().delete(path);
    }

    /**
    * return put response.
     *
     * @param path:String
     * @param transaction:Map
     * @author osca.restrepo
    * */
    public static Response putResponse(String path, Map transaction) {
        return given().contentType(JSON).body(transaction).put(path);
    }

    /**
     * return post response.
     *
     * @param path:String
     * @param transaction:Map
     * @author osca.restrepo
     * */
    public static Response postResponse(String path, Map transaction) {
        return given().contentType(JSON).body(transaction).post(path);
    }

}