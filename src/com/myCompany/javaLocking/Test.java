package com.myCompany.javaLocking;

/**
 * @author Tatek Ahmed on 2/8/2022
 */
//In this example object of test can execute both methods.
//Because the object possesses the lock.
public class Test{

    public synchronized int foo(){
        //do something
        bar();
        return 1;
    }

    public synchronized int bar(){
        //do some more
        return 0;
    }
}
