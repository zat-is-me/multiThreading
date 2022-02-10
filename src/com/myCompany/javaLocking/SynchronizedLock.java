package com.myCompany.javaLocking;

/**
 * @author Tatek Ahmed on 2/8/2022
 */

public class SynchronizedLock implements Runnable{

    private Resource resource;

    public SynchronizedLock(Resource r){
        this.resource = r;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.doSomething();
        }
        resource.doLogging();
    }
}