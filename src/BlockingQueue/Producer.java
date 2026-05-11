package BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        int value = 1;

        try {
            while (true) {

                System.out.println("Produced: " + value);

                // put() blocks if queue is full
                queue.put(value);

                value++;

                Thread.sleep(1000);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            while (true) {

                // take() blocks if queue is empty
                int value = queue.take();

                System.out.println("Consumed: " + value);

                Thread.sleep(2000);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // Capacity = 5
        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(5);

        Thread producerThread =
                new Thread(new Producer(queue));

        Thread consumerThread =
                new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}