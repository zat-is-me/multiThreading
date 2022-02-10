package com.myCompany.javaLocking;


/**
 * @author Tatek Ahmed on 2/8/2022
 */
public class Resource {
    int count = 0;

    public void doSomething() {

        //do some operation, DB read, write etc
        System.out.println("Doing db connection");
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public void doLogging(){
        //logging, no need for thread safety
        System.out.println("Doing logging");
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }
}