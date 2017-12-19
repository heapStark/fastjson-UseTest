import com.google.common.util.concurrent.ThreadFactoryBuilder;
import heapStark.concurrentTest.callable.Call;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;


/**
 * Created by wangzhilei3 on 2017/12/19.
 */
public class MainTest {
    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void voidTest() {

    }

    @Test
    public void callableTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(new Call());
        try {
            List<String> result = null;
            //List<String> result = (List) future.get();
            //executorService.shutdownNow();//调用future.get()抛出异常
            future.cancel(false);
            while (!future.isDone()){
                logger.info("not done");
                TimeUnit.SECONDS.sleep(2);
            }
            logger.info("is done:{}",future.isDone());
            result = (List) future.get();
            for (String s : result) {
                logger.info(s);
            }
        } catch (InterruptedException e) {
            logger.error("error", e);
        } catch (Exception e) {
            logger.error("error", e);
        }

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
