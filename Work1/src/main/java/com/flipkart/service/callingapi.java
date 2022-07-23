//package com.flipkart.service;
//
//import ch.qos.logback.core.net.server.Client;
//import netscape.javascript.JSObject;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.core.Request;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//public class callingapi {
//
//
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        var url="https://api.covid19api.com/summary";
//        var request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
//        var client= HttpClient.newBuilder().build();
//        var response= client.send(request, HttpResponse.BodyHandlers.ofString());
//
//
//
//    }
//}
