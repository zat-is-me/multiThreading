package com.myCompany.javaLocking;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Tatek Ahmed on 2/8/2022
 **/

public class MultiThreadingProcessor {
    public BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void producer() throws InterruptedException {
        Random random = new Random();
        while (true){
            queue.put(random.nextInt(100));
        }
    }

    public void consumer() throws InterruptedException {
        Random random = new Random();

        while (true){
            Thread.sleep(100);
            if (random.nextInt(10) == 0){
                Integer value = queue.take();
                System.out.println("Taken value: "+ value + "; Queue size is: " + queue.size());
            }
        }
    }
}
