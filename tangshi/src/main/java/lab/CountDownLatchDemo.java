package lab;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    private static class Job implements Runnable{
        private CountDownLatch countDownLatch;
        Job(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            countDownLatch.countDown();//调完就减1
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //相当于定义了计数器有十个数
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i=0;i<10;i++){
            Thread thread = new Thread(new Job(countDownLatch));
            thread.start();
        }
        countDownLatch.await();//计数器为0了才会返回，否则一直等着
        //10个线程就全部结束了
    }

}
