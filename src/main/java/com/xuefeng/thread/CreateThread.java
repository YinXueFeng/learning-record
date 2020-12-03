package com.xuefeng.thread;


import java.util.concurrent.*;

public class CreateThread{
    /**
     * 创建线程有四种方式：
     *  1. 继承Thread类
     *  2. 实现Runnable接口
     *  3. 实现Callable接口
     *  4. 使用线程池
     */

    public static void main(String[] args) {

        // 方法一：继承Thread类
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();


        // 方法二：实现Runnable接口
        TicketTwo ticketTwo = new TicketTwo();
        Thread thread1 = new Thread(ticketTwo);
        Thread thread2 = new Thread(ticketTwo);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread1.start();
        thread2.start();

        // 方法三：实现Callable接口，需要借助FutureTask
        TicketThree ticketThree = new TicketThree();
        FutureTask<Integer> future = new FutureTask<Integer>(ticketThree);
        new Thread(future).start();
        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 方法四：使用线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newScheduledThreadPool(100);

        // 适合使用Runnable
        service.execute(new TicketTwo());
        // 适合使用Callable
//        service.submit(Callable callable);
    }
}



/**
 * 方法一：继承Thread类
 *  1. 继承Thread类
 *  2. 重写run()方法
 *  3. 创建子类对象
 *  4. 调用子类对象的start()方法
 */
class Ticket extends Thread {
    private int ticket = 100;
    @Override
    public  void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

}


/**
 * 方式二：实现Runnable接口
 *  1. 创建实现Runnable接口的类
 *  2. 实现Runnable的抽象方法run()
 *  3. 创建实现类的对象
 *  4. 将此对象作为构造器参数，传入Thread类中
 *  5. 通过Thread类的对象调用run()
 *
 */
class TicketTwo implements Runnable {
    private int ticket = 100;
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

/**
 * 方式三：实现Callable接口
 *  1. 创建一个实现Callable<T>的类
 *  2. 实现call()方法，
 *  3. 创建Callable实现类的对象
 *  4. 将Callable实现类的对象作为构造器参数，传入FutureTask中，创建FutureTask的对象
 *  5. 将FutureTask的对象作为参数传入Thread中，创建Thread的对象
 *  6. 使用Thread的对象调用start()
 *
 */
class TicketThree implements Callable<Integer> {
    private int ticket = 100;
    public Integer call() throws Exception {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
        return ticket;
    }
}
