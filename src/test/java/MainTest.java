import com.google.common.util.concurrent.ThreadFactoryBuilder;
import heapStark.concurrentTest.callable.Call;
import heapStark.concurrentTest.callable.SumTask;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


/**
 * Created by wangzhilei3 on 2017/12/19.
 */
public class MainTest {
    private final static Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void voidTest() {

    }

    /**
     * fork join Test
     *
     */
    @Test
    public void forkJoinTest() {
        ForkJoinPool pool = new ForkJoinPool();
        SumTask sumTask = new SumTask(1,10);
        Future<Integer> future = pool.submit(sumTask);
        try {
            logger.info(":{}",future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    /**
     * ScheduledExecutorServiceTest
     * 支持延时，支持周期任务
     */
    @Test
    public void ScheduledExecutorServiceTest() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        Future singleFuture = executorService.schedule(() -> {
            logger.error("");
        }, 3, TimeUnit.SECONDS);
        Future callFuture = executorService.schedule(() -> {
            return "hello";
        }, 5, TimeUnit.SECONDS);
        try {
            logger.info(":{}", singleFuture.get());
            logger.info(":{}", callFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ScheduledFuture future = executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                logger.info("date:{}", new Date());
            }
        }, 5, 5, TimeUnit.SECONDS);
        /*try {
            future.get();
        } catch (InterruptedException e) {
            logger.error("error",e);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        logger.info("test:{}", future.isDone());
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("e", e);
        }
    }

    /**
     * executorService Test
     */
    @Test
    public void callableTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        logger.info(":{}", executorService.isShutdown());
        logger.info(":{}", executorService.isTerminated());
        Future<List<String>> future = executorService.submit(new Call());
        try {
            List<String> result = null;
            //List<String> result = (List) future.get();
            executorService.shutdownNow();//调用future.get()抛出异常
            //future.cancel(false);

            while (!future.isDone()) {
                logger.info("not done");
                TimeUnit.SECONDS.sleep(2);
            }
            logger.info("is done:{}", future.isDone());
            result = (List) future.get();
            logger.info("");
            for (String s : result) {
                logger.info(s);
            }
        } catch (InterruptedException e) {
            logger.error("error", e);
        } catch (Exception e) {
            logger.error("error", e);
        }
        logger.info(":{}", executorService.isShutdown());
        logger.info(":{}", executorService.isTerminated());

    }

    /**
     * ThreadFactoryBuilder test
     */
    @Test
    public void threadFactoryTest() {
        logger.info("test");
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Orders-%d")
                .setDaemon(true)
                .build();

        final ExecutorService executorService = Executors.newFixedThreadPool(10, threadFactory);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    logger.info("thread name :{}", Thread.currentThread().getName());
                    //[Orders-9] - [MainTest$1.run(MainTest.java:30)] - thread name :Orders-9
                }
            });
        }
    }
}
