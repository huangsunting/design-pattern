package com.bravo.pattern.chain_of_responsibility.filter;

public class Servlet {
    public void service(Request req, Response res) {
        System.out.println("Servlet执行");
    }
}